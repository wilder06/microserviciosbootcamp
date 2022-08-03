package pe.com.bank.movementservice.service;

import pe.com.bank.movementservice.entity.MovementEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {

    Mono<MovementEntity> saveMovement(MovementEntity movementEntity);

    Mono<MovementEntity> findByIdMovement(String id);

    Mono<MovementEntity> updateMovement(String id,MovementEntity movementEntity);

    Mono<Void> deleteByIdMovement(String id);

    Flux<MovementEntity> findAllMovement();

    Flux<MovementEntity> findByDocumentNumber(Integer documentNumber);

}
