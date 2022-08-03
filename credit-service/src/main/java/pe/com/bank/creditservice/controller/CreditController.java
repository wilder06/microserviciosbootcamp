package pe.com.bank.creditservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bank.creditservice.entity.CreditEntity;
import pe.com.bank.creditservice.service.CreditService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping
    public Mono<CreditEntity> saveCredit(@RequestBody @Valid CreditEntity creditEntity) {
        return this.creditService.saveCredit(creditEntity);
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<CreditEntity>> findByCredit(@PathVariable String id) {
        return this.creditService.findByIdCredit(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<CreditEntity>> updateCredit(@PathVariable String id, @RequestBody @Valid CreditEntity creditEntity) {
        return this.creditService.updateCredit(id,creditEntity).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @GetMapping("/search/{numberDocument}")
    public Flux<ResponseEntity<CreditEntity>> findByNumberDocument(@PathVariable Integer numberDocument) {
        return this.creditService.findByDocumentNumber(numberDocument).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteIdCredit(@PathVariable String id) {
        return this.creditService.deleteByIdCredit(id);
    }
    @GetMapping()
    public Flux<CreditEntity> findAllCredit() {
        return this.creditService.findAllCredit();
    }
}
