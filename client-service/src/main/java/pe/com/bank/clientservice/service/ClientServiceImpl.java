package pe.com.bank.clientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bank.clientservice.client.CreditService;
import pe.com.bank.clientservice.client.DebitService;
import pe.com.bank.clientservice.client.MovementService;
import pe.com.bank.clientservice.dto.MovementDto;
import pe.com.bank.clientservice.entity.ClientEntity;
import pe.com.bank.clientservice.repository.ClientRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DebitService debitService;

    @Autowired
    private CreditService creditService;

    @Autowired
    private MovementService movementService;

    @Override
    public Mono<ClientEntity> saveClient(ClientEntity clientEntity) {
        return null;
      /*  return clientRepository.findByDocumentNumber(clientEntity.getDocumentNumber())
                .flatMap(client -> {
                    CreditDto credit= (CreditDto) client.getCredit();
                    int b = credit.getExpiryDate().compareTo(credit.getDateRate());
                    if(b > 0){
                    return clientRepository.save(clientEntity);
                    }else {
                        return Mono.just("The customer has an experienced debt ");
                    }
                });*/
    }

    @Override
    public Mono<ClientEntity> findByIdClient(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public Mono<ClientEntity> updateClient(String id,ClientEntity clientEntity) {
        return clientRepository.findById(id)
                .map(client->client)
                .flatMap(cient->clientRepository.save(clientEntity))
                .switchIfEmpty(Mono.error(new Exception("Client no exist with"+id)));
    }

    @Override
    public Mono<Void> deleteByIdClient(String id) {
        return clientRepository.deleteById(id);
    }

    @Override
    public Flux<ClientEntity> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<ClientEntity> consolidatedSummaryClient(Integer documentNumber) {

        //DebitDto clientDebit = debitService.findByNumberDocument(documentNumber).block();
        // Mono<CreditDto> clientCredit = creditService.findByNumberDocument(documentNumber);
        // Mono<ClientEntity>clientEntity =clientRepository.findByDocumentNumber(documentNumber);

        return clientRepository.findByDocumentNumber(documentNumber);
    }

    @Override
    public Flux<MovementDto> getTenEndMovements(Integer documentNumber) {
        return movementService.findByDocumentNumber(documentNumber).limitRate(10);
    }
}
