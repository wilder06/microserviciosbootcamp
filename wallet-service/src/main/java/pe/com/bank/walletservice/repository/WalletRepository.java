package pe.com.bank.walletservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bank.walletservice.entity.WalletEntity;

@Repository
public interface WalletRepository extends ReactiveMongoRepository<WalletEntity,String> {
}
