package pe.com.bank.walletservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bank.walletservice.entity.OrderBootCoin;

@Repository
public interface OrderBootCoinRepository extends ReactiveMongoRepository<OrderBootCoin,String> {
}
