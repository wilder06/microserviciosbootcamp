package pe.com.bank.cardservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bank.cardservice.entity.CardEntity;

@Repository
public interface CardRepository extends ReactiveMongoRepository<CardEntity,String> {
}
