package pe.com.bank.walletservice.service;

import pe.com.bank.walletservice.repository.WalletBootCoinRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WalletBootCoinService {
    Flux<WalletBootCoinRepository> findAll();
    Mono<WalletBootCoinRepository>save(WalletBootCoinRepository walletBootCoin);
}
