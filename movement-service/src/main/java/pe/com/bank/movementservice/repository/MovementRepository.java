package pe.com.bank.movementservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bank.movementservice.entity.MovementEntity;
import reactor.core.publisher.Flux;

@Repository
public interface MovementRepository extends ReactiveMongoRepository<MovementEntity,String> {
    Flux<MovementEntity> findByDocumentNumber(Integer documentNumber);
}
