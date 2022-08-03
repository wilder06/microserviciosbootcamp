package pe.com.bank.clientservice.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.com.bank.clientservice.entity.ClientEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientCreatedEvent extends Event<ClientEntity> {

}
