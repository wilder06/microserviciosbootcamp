package pe.com.bank.walletservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.com.bank.walletservice.dto.MovementDto;
import pe.com.bank.walletservice.events.Event;
import pe.com.bank.walletservice.events.EventType;
import pe.com.bank.walletservice.events.MovementDtoCreatedEvent;

import java.util.Date;
import java.util.UUID;

@Component
public class MovementEventsService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.movement.name:movements}")
	private String topicMovementDto;
	
	public void publish(MovementDto movementDto) {

		MovementDtoCreatedEvent created = new MovementDtoCreatedEvent();
		created.setData(movementDto);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());

		this.producer.send(topicMovementDto, created);
	}
	
	

}
