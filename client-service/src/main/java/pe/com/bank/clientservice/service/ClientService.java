package pe.com.bank.clientservice.service;

import pe.com.bank.clientservice.dto.MovementDto;
import pe.com.bank.clientservice.entity.ClientEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    Mono<ClientEntity> saveClient(ClientEntity clientEntity);

    Mono<ClientEntity> findByIdClient(String id);

    Mono<ClientEntity> updateClient(String id,ClientEntity clientEntity);

    Mono<Void> deleteByIdClient(String id);

    Flux<ClientEntity> findAllClient();

    Mono<ClientEntity>consolidatedSummaryClient(Integer documentNumber);
    Flux<MovementDto>getTenEndMovements(Integer documentNumber);
}
