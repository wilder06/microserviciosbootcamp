package pe.com.bank.walletservice.service;


import pe.com.bank.walletservice.entity.OrderBootCoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderBootCoinService {
    Mono<OrderBootCoin>saveOrder(OrderBootCoin orderBootCoin);
    Flux<OrderBootCoin> findAll();

    Mono<OrderBootCoin> findById(String id);

}
