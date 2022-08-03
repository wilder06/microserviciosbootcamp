package pe.com.bank.debitservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bank.debitservice.entity.DebitEntity;
import pe.com.bank.debitservice.repository.DebitRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DebitServiceImpl implements DebitService {

    @Autowired
    private DebitRepository debitRepository;

    @Override
    public Mono<DebitEntity> saveDebit(DebitEntity debitEntity) {
        return debitRepository.save(debitEntity);
    }

    @Override
    public Mono<DebitEntity> findByIdDebit(String id) {
        return debitRepository.findById(id);
    }

    @Override
    public Mono<DebitEntity> updateDebit(String id,DebitEntity debitEntity) {
        return debitRepository.findById(id).map(debit->debit)
                .flatMap(debit->debitRepository.save(debitEntity))
                .switchIfEmpty(Mono.error(new Exception("Debit account no exists with id"+id)));
    }

    @Override
    public Mono<Void> deleteByIdDebit(String id) {
        return debitRepository.deleteById(id);
    }

    @Override
    public Flux<DebitEntity> findAllDebit() {
        return debitRepository.findAll();
    }

    @Override
    public Flux<DebitEntity> findByDocumentNumber(Integer numberDocument) {
        return (Flux<DebitEntity>) debitRepository.findByDocumentNumber(numberDocument);
    }

    @Override
    public Mono<DebitEntity> findByAccountNumber(String accountNumber) {
        return debitRepository.findByAccountNumber(accountNumber).filter(account -> account.getPriority().equals("PRINCIPAL"));
    }
}
