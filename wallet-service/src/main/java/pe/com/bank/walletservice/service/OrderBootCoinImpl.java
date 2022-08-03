package pe.com.bank.walletservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bank.walletservice.client.DebitEventsService;
import pe.com.bank.walletservice.entity.OrderBootCoin;
import pe.com.bank.walletservice.entity.PayType;
import pe.com.bank.walletservice.repository.OrderBootCoinRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

@Service
public class OrderBootCoinImpl implements OrderBootCoinService {

    @Autowired
    private OrderBootCoinRepository orderBootCoinRepository;

    @Autowired
    private DebitEventsService debitEventsService;

    @Autowired
    private WalletService walletService;

    @Override
    public Mono<OrderBootCoin> saveOrder(OrderBootCoin orderBootCoin) {
        Mono<OrderBootCoin> saveOrderBotcoin = null;
        if (orderBootCoin.getPayType().equals(PayType.TRANSFER)) {
            debitEventsService.publish(orderBootCoin.getDebitDto());
            saveOrderBotcoin = orderBootCoinRepository.save(orderBootCoin);
            return saveOrderBotcoin;
        } else if (orderBootCoin.getPayType().equals(PayType.YANKI)) {
            saveOrderBotcoin = orderBootCoinRepository.save(orderBootCoin);
            walletService.saveWallet(orderBootCoin.getWalletEntity());
            return saveOrderBotcoin;
        } else {
            return saveOrderBotcoin.switchIfEmpty(Mono.error(new Exception("Not exits wallet or account debit")));
        }

    }

    @Override
    public Flux<OrderBootCoin> findAll() {
        return orderBootCoinRepository.findAll();
    }

    @Override
    public Mono<OrderBootCoin> findById(String id) {
        return orderBootCoinRepository.findById(id);
    }

    public boolean validBuyBootCoin(Mono<OrderBootCoin> orderBootCoinMono) {
        List<OrderBootCoin> orderBootCoin = (List<OrderBootCoin>) findById(orderBootCoinMono.block().getId()).block();
        return orderBootCoin.stream().anyMatch(order -> {
            boolean isValid;
            return isValid = order.getPayType() != null && order.getTotalShippingCost() != null || order.getPhoneNumber() != null || order.getAccountNumber() != null;

        });
    }
}
