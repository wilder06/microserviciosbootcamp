package pe.com.bank.debitservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.com.bank.debitservice.events.DebitCreatedEvent;
import pe.com.bank.debitservice.events.Event;

@Slf4j
@Component
public class MovementEventsService {
    @Autowired
    private DebitService debitService;

    @KafkaListener(
            topics = "${topic.debit.name:debits}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo3")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(DebitCreatedEvent.class)) {
            DebitCreatedEvent debitCreatedEvent = (DebitCreatedEvent) event;
            debitService.updateDebit(debitCreatedEvent.getId(),debitCreatedEvent.getData());
            log.info("Received Debit account created event .... with data={}",
                    debitCreatedEvent.getData().toString());
        }


    }


}
