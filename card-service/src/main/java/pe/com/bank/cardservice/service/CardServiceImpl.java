package pe.com.bank.cardservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pe.com.bank.cardservice.entity.CardEntity;
import pe.com.bank.cardservice.repository.CardRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Mono<CardEntity> saveCard(CardEntity cardEntity) {
        return cardRepository.save(cardEntity);
    }
    @Override
   // @Cacheable(cacheNames = "card-cache", unless = "#result == null")
    @Cacheable(value = "card-cache")
    public Mono<CardEntity> findByIdCard(String id) {
        return cardRepository.findById(id);
    }

    @Override
    @CachePut(cacheNames = "card-cache", key = "#id", unless = "#result == null")
    //@CachePut(value = "cardCache")
    public Mono<CardEntity> updateCard(String id,CardEntity cardEntity) {
        return cardRepository.findById(id)
                .map(card->card)
                .flatMap(car->cardRepository.save(cardEntity))
                .switchIfEmpty(Mono.error(new Exception("No exists card with "+id)));
    }

    @Override
    @CacheEvict(cacheNames = "card-cache", key = "#id")
   // @CacheEvict(value = "cardCache")
    public Mono<Void> deleteByIdCard(String id) {
        return cardRepository.deleteById(id);
    }

    @Override
    public Flux<CardEntity> findAllCard() {
        return cardRepository.findAll();
    }
}
