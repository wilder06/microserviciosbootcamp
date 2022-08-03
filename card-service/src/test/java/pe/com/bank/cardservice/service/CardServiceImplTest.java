package pe.com.bank.cardservice.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pe.com.bank.cardservice.config.TestConfig;
import pe.com.bank.cardservice.dto.ClientDto;
import pe.com.bank.cardservice.entity.CardEntity;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@TestConfig
class CardServiceImplTest {

    @Mock
    private CardService cardService;

    @Test
    void saveCard() {

        ClientDto clientDto = new ClientDto();
        clientDto.setId("1");
        clientDto.setFullName("Wilder Pacpac");
        CardEntity cardEntity = new CardEntity();
        cardEntity.setId("1");
        cardEntity.setCardNumber("123456789");
        cardEntity.setAccountNumber("987654321");
        cardEntity.setClientType("NATURAL");
        cardEntity.setCreditMaxAmount(2);
        cardEntity.setClientDto(clientDto);
        Mono<CardEntity> cardEntityMono= this.cardService.saveCard(cardEntity);
        StepVerifier.create(cardEntityMono).expectNextMatches(saved-> saved !=null);
    }

    @Test
    void findByIdCard() {
    }

    @Test
    void updateCard() {
    }

    @Test
    void deleteByIdCard() {
    }

    @Test
    void findAllCard() {
    }
}