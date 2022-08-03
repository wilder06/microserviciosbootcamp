package pe.com.bank.movementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bank.movementservice.entity.MovementEntity;
import pe.com.bank.movementservice.repository.MovementRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementServiceImpl implements MovementService{

    @Autowired
    private MovementRepository movementRepository;
    @Override
    public Mono<MovementEntity> saveMovement(MovementEntity movementEntity) {
        return movementRepository.save(movementEntity);
    }

    @Override
    public Mono<MovementEntity> findByIdMovement(String id) {
        return movementRepository.findById(id);
    }

    @Override
    public Mono<MovementEntity> updateMovement(String id,MovementEntity movementEntity) {
        return movementRepository.findById(id)
                .map(move->move)
                .flatMap(movement->movementRepository.save(movementEntity))
                .switchIfEmpty(Mono.error(new Exception("Movement no exits")));
    }

    @Override
    public Mono<Void> deleteByIdMovement(String id) {
        return movementRepository.deleteById(id);
    }

    @Override
    public Flux<MovementEntity> findAllMovement() {
        return movementRepository.findAll();
    }

    @Override
    public Flux<MovementEntity> findByDocumentNumber(Integer documentNumber) {
        return movementRepository.findByDocumentNumber(documentNumber);
    }
}
