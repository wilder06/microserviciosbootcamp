package pe.com.bank.movementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bank.movementservice.entity.MovementEntity;
import pe.com.bank.movementservice.service.MovementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/movement")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @PostMapping
    public Mono<MovementEntity> saveMovement(@RequestBody @Valid MovementEntity movementEntity) {
        return this.movementService.saveMovement(movementEntity);
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<MovementEntity>> findByMovement(@PathVariable String id) {
        return this.movementService.findByIdMovement(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<MovementEntity>> updateMovement(@PathVariable String id, @RequestBody @Valid MovementEntity movementEntity) {
        return this.movementService.updateMovement(id, movementEntity).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteIdMovement(@PathVariable String id) {
        return this.movementService.deleteByIdMovement(id);
    }

    @GetMapping()
    public Flux<MovementEntity> findAllDebit() {
        return this.movementService.findAllMovement();
    }

    @GetMapping("/search/documentNumber")
    public Flux<ResponseEntity<MovementEntity>> findBydocumentNumber(@PathVariable Integer documentNumber) {
        return this.movementService.findByDocumentNumber(documentNumber).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
