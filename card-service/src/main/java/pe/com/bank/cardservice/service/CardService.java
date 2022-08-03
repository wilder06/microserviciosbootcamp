package pe.com.bank.cardservice.service;

import pe.com.bank.cardservice.entity.CardEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {

    Mono<CardEntity> saveCard(CardEntity cardEntity);

    Mono<CardEntity> findByIdCard(String id);

    Mono<CardEntity> updateCard(String id,CardEntity cardEntity);

    Mono<Void> deleteByIdCard(String id);

    Flux<CardEntity> findAllCard();
}
