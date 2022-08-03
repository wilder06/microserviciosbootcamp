package pe.com.bank.creditservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bank.creditservice.entity.CreditEntity;
import pe.com.bank.creditservice.repository.CreditRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService{

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Mono<CreditEntity> saveCredit(CreditEntity creditEntity) {
        return creditRepository.save(creditEntity);
    }

    @Override
    public Mono<CreditEntity> findByIdCredit(String id) {
        return creditRepository.findById(id);
    }

    @Override
    public Mono<CreditEntity> updateCredit(String id,CreditEntity creditEntity) {

        return creditRepository.findById(id)
                .map(credit->credit)
                .flatMap(credit->creditRepository.save(creditEntity))
                .switchIfEmpty(Mono.error(new Exception("Credit account no exists with id"+creditEntity.getAccountNumber())));
    }

    @Override
    public Mono<Void> deleteByIdCredit(String id) {
        return creditRepository.deleteById(id);
    }

    @Override
    public Flux<CreditEntity> findAllCredit() {
        return creditRepository.findAll();
    }

    @Override
    public Flux<CreditEntity> findByDocumentNumber(Integer documentNumber) {
        return creditRepository.findByDocumentNumber(documentNumber);
    }
}
