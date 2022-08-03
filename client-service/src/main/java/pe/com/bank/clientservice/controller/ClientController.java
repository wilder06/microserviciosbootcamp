package pe.com.bank.clientservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bank.clientservice.entity.ClientEntity;
import pe.com.bank.clientservice.service.ClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Mono<ClientEntity> saveClient(@RequestBody @Valid ClientEntity clientEntity) {
        log.info("Save client {}",clientEntity);
        return this.clientService.saveClient(clientEntity);
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<ClientEntity>> findByClient(@PathVariable String id) {
        log.info("Search client by id {}", id);
        return this.clientService.findByIdClient(id) .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/{documentNumber}")
    public Mono<ResponseEntity<ClientEntity>> findByDocumentNumber(@PathVariable Integer documentNumber) {
        log.info("Search client by document number {}", documentNumber);

        return this.clientService.consolidatedSummaryClient(documentNumber).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<ClientEntity>> updateClient(@PathVariable String id,@RequestBody @Valid ClientEntity clientEntity) {
        log.info("Update client by id {}", id);
        return this.clientService.updateClient(id,clientEntity) .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteIdClient(@PathVariable String id) {
        log.info("Delete client id {}", id);
        return this.clientService.deleteByIdClient(id);
    }

    @GetMapping()
    public Flux<ClientEntity> findAllClient() {

        log.info("List all clients");
        return this.clientService.findAllClient();
    }
}
