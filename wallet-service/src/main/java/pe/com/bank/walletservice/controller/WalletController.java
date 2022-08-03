package pe.com.bank.walletservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bank.walletservice.entity.WalletEntity;
import pe.com.bank.walletservice.service.WalletService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public Mono<WalletEntity> saveWallet(@RequestBody @Valid WalletEntity walletEntity) {
        return this.walletService.saveWallet(walletEntity);
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<WalletEntity>> findByWallet(@PathVariable String id) {

        return this.walletService.findByIdWallet(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<WalletEntity>> updateWallet(@PathVariable String id, @RequestBody @Valid WalletEntity walletEntity) {
        return this.walletService.updateWallet(id, walletEntity)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteIdWallet(@PathVariable String id) {
        return this.walletService.deleteByIdWallet(id);
    }

    @GetMapping()
    public Flux<WalletEntity> findAllWallet() {
        return this.walletService.findAllWallet();
    }
}
