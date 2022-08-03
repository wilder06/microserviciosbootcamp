package pe.com.bank.walletservice.service;

import pe.com.bank.walletservice.entity.WalletEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WalletService {

    Mono<WalletEntity> saveWallet(WalletEntity walletEntity);

    Mono<WalletEntity> findByIdWallet(String id);

    Mono<WalletEntity> updateWallet(String id,WalletEntity walletEntity);

    Mono<Void> deleteByIdWallet(String id);

    Flux<WalletEntity> findAllWallet();
}
