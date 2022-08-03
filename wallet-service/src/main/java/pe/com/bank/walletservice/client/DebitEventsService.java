package pe.com.bank.walletservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.com.bank.walletservice.dto.DebitDto;
import pe.com.bank.walletservice.events.DebitDtoCreatedEvent;
import pe.com.bank.walletservice.events.Event;
import pe.com.bank.walletservice.events.EventType;
import java.util.Date;
import java.util.UUID;

@Component
public class DebitEventsService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.debit.name:debits}")
	private String topicDebitDto;
	
	public void publish(DebitDto debitDto) {

		DebitDtoCreatedEvent created = new DebitDtoCreatedEvent();
		created.setData(debitDto);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());

		this.producer.send(topicDebitDto, created);
	}
	
	

}
