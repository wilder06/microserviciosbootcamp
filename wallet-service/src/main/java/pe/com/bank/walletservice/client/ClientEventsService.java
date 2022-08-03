package pe.com.bank.walletservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.com.bank.walletservice.dto.ClientDto;
import pe.com.bank.walletservice.events.ClientDtoCreatedEvent;
import pe.com.bank.walletservice.events.Event;
import pe.com.bank.walletservice.events.EventType;
import java.util.Date;
import java.util.UUID;

@Component
public class ClientEventsService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.client.name:clients}")
	private String topicClientDto;
	
	public void publish(ClientDto clientDto) {

		ClientDtoCreatedEvent created = new ClientDtoCreatedEvent();
		created.setData(clientDto);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());

		this.producer.send(topicClientDto, created);
	}
	
	

}
