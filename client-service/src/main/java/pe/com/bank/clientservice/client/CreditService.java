package pe.com.bank.clientservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.com.bank.clientservice.dto.CreditDto;
import reactor.core.publisher.Flux;

@Service
public class CreditService {
    private final WebClient webClient;


    public CreditService(@Value("${credit.service.url}") String url) {
        this.webClient = WebClient.builder().baseUrl(url).build();
    }

    public Flux<CreditDto> findByNumberDocument(Integer  numberDocument) {
        return this.webClient.get()
                .uri("/credit/search/"+numberDocument)
                .retrieve()
                .bodyToFlux(CreditDto.class);
    }
}
