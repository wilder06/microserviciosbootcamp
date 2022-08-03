package pe.com.bank.creditservice.service;

import pe.com.bank.creditservice.entity.CreditEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {

    Mono<CreditEntity> saveCredit(CreditEntity creditEntity);

    Mono<CreditEntity> findByIdCredit(String id);

    Mono<CreditEntity> updateCredit(String id,CreditEntity creditEntity);

    Mono<Void> deleteByIdCredit(String id);

    Flux<CreditEntity> findAllCredit();

    Flux<CreditEntity> findByDocumentNumber(Integer documentNumber);

}
