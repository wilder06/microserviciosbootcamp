package pe.com.bank.clientservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.com.bank.clientservice.dto.DebitDto;
import reactor.core.publisher.Flux;

@Service
public class DebitService {
    private final WebClient webClient;


    public DebitService(@Value("${debit.service.url}") String url) {
        this.webClient = WebClient.builder().baseUrl(url).build();
    }

    public Flux<DebitDto> findByNumberDocument(Integer numberDocument) {
        return this.webClient.get()
                .uri("/debit/search/"+numberDocument)
                .retrieve()
                .bodyToFlux(DebitDto.class);
    }
}
