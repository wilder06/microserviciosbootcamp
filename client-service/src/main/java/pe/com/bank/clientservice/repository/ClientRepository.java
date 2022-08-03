package pe.com.bank.clientservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bank.clientservice.entity.ClientEntity;
import reactor.core.publisher.Mono;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<ClientEntity,String> {

    Mono<ClientEntity> findByDocumentNumber(Integer documentNumber);
}
