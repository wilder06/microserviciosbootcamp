package pe.com.bank.walletservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bank.walletservice.client.ClientEventsService;
import pe.com.bank.walletservice.entity.WalletEntity;
import pe.com.bank.walletservice.repository.WalletRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private ClientEventsService clientEventsService;
    @Override
    public Mono<WalletEntity> saveWallet(WalletEntity walletEntity) {
        log.info("Producing client {}", walletEntity.getClient());
        this.clientEventsService.publish(walletEntity.getClient());
        return walletRepository.save(walletEntity);
    }
    @Override
    public Mono<WalletEntity> findByIdWallet(String id) {
        log.info("Wallet find by ID {}", id);
        return walletRepository.findById(id);
    }

    @Override
    public Mono<WalletEntity> updateWallet(String id, WalletEntity walletEntity) {
        return walletRepository.findById(id)
                .map(wall->wall)
                .flatMap(wallet->walletRepository.save(walletEntity))
                .switchIfEmpty(Mono.error(new Exception("Error Wallet update")));
    }
    @Override
    public Mono<Void> deleteByIdWallet(String id) {
        return null;
    }

    @Override
    public Flux<WalletEntity> findAllWallet() {
        return null;
    }
}
