package pe.com.bank.debitservice.service;

import pe.com.bank.debitservice.entity.DebitEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DebitService {

    Mono<DebitEntity> saveDebit(DebitEntity debitEntity);

    Mono<DebitEntity> findByIdDebit(String id);

    Mono<DebitEntity> updateDebit(String id,DebitEntity debitEntity);

    Mono<Void> deleteByIdDebit(String id);

    Flux<DebitEntity> findAllDebit();

    Flux<DebitEntity> findByDocumentNumber(Integer documentNumber);
    Mono<DebitEntity> findByAccountNumber(String accountNumber);


}
