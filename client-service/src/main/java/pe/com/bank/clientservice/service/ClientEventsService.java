package pe.com.bank.clientservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.com.bank.clientservice.events.ClientCreatedEvent;
import pe.com.bank.clientservice.events.Event;

@Slf4j
@Component
public class ClientEventsService {
    @Autowired
    private ClientService clientService;

    @KafkaListener(
            topics = "${topic.client.name:clients}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(ClientCreatedEvent.class)) {
            ClientCreatedEvent clientCreatedEvent = (ClientCreatedEvent) event;
            clientService.updateClient(clientCreatedEvent.getId(),clientCreatedEvent.getData());
            log.info("Received Client created event .... with data={}",
                    clientCreatedEvent.getData().toString());
        }


    }


}
