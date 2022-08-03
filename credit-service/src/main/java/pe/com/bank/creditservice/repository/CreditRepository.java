package pe.com.bank.creditservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bank.creditservice.entity.CreditEntity;
import reactor.core.publisher.Flux;

@Repository
public interface CreditRepository extends ReactiveMongoRepository<CreditEntity,String> {
    Flux<CreditEntity> findByDocumentNumber(Integer documentNumber);
}
