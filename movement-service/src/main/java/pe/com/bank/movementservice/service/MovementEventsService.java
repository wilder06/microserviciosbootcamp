package pe.com.bank.movementservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.com.bank.movementservice.events.Event;
import pe.com.bank.movementservice.events.MovementCreatedEvent;

@Slf4j
@Component
public class MovementEventsService {
    @Autowired
    private MovementService movementService;

    @KafkaListener(
            topics = "${topic.movement.name:movements}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo2")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(MovementCreatedEvent.class)) {
            MovementCreatedEvent movementCreatedEvent = (MovementCreatedEvent) event;
            movementService.saveMovement(movementCreatedEvent.getData());
            log.info("Received Movement created event .... with data={}",
                    movementCreatedEvent.getData().toString());
        }


    }


}
