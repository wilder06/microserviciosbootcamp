package pe.com.bank.debitservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bank.debitservice.entity.DebitEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface DebitRepository extends ReactiveMongoRepository<DebitEntity,String> {
    Flux<DebitEntity> findByDocumentNumber(Integer documentNumber);
    Mono<DebitEntity> findByAccountNumber(String accountNumber);

}
