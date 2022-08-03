package pe.com.bank.debitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bank.debitservice.entity.DebitEntity;
import pe.com.bank.debitservice.service.DebitService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/debit")
public class DebitController {

    @Autowired
    private DebitService debitService;

    @PostMapping
    public Mono<DebitEntity> saveDebit(@RequestBody @Valid DebitEntity debitEntity) {
        return this.debitService.saveDebit(debitEntity);
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<DebitEntity>> findByDebit(@PathVariable String id) {
        return this.debitService.findByIdDebit(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<DebitEntity>> updateDebit(@PathVariable String id, @RequestBody @Valid DebitEntity debitEntity) {
        return this.debitService.updateDebit(id, debitEntity).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteIdDebit(@PathVariable String id) {
        return this.debitService.deleteByIdDebit(id);
    }

    @GetMapping()
    public Flux<DebitEntity> findAllDebit() {
        return this.debitService.findAllDebit();
    }

    @GetMapping("/search/{numberDocument}")
    public Flux<ResponseEntity<DebitEntity>> findByDocumentNumber(@PathVariable Integer numberDocument) {
        return this.debitService.findByDocumentNumber(numberDocument).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/accountMain/{accountNumber}")
    public Mono<ResponseEntity<DebitEntity>> getBalanceAccountMain(@PathVariable String accountNumber) {
        return this.debitService.findByAccountNumber(accountNumber).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
