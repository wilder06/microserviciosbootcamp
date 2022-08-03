package pe.com.bank.walletservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bank.walletservice.repository.WalletBootCoinRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WalletBootCoinServiceImpl implements  WalletBootCoinService{

    @Autowired
    private WalletBootCoinRepository walletBootCoinRepository;
    @Override
    public Flux<WalletBootCoinRepository> findAll() {
        return walletBootCoinRepository.findAll();
    }

    @Override
    public Mono<WalletBootCoinRepository> save(WalletBootCoinRepository walletBootCoin) {
        return walletBootCoinRepository.save(walletBootCoin);
    }
}
