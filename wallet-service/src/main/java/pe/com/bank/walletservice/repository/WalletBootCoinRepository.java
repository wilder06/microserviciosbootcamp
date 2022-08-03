package pe.com.bank.walletservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletBootCoinRepository extends ReactiveMongoRepository<WalletBootCoinRepository,String> {
}
