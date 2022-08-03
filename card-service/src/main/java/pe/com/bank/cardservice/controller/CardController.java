package pe.com.bank.cardservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bank.cardservice.entity.CardEntity;
import pe.com.bank.cardservice.service.CardService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public Mono<CardEntity> saveCard(@RequestBody @Valid CardEntity cardEntity) {
        return this.cardService.saveCard(cardEntity);
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<CardEntity>> findByCard(@PathVariable String id) {

        return this.cardService.findByIdCard(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<CardEntity>> updateCard(@PathVariable String id, @RequestBody @Valid CardEntity cardEntity) {
        return this.cardService.updateCard(id,cardEntity)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteIdCard(@PathVariable String id) {
        return this.cardService.deleteByIdCard(id);
    }

    @GetMapping()
    public Flux<CardEntity> findAllCard() {
        return this.cardService.findAllCard();
    }
}
