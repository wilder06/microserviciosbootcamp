package pe.com.bank.walletservice.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.com.bank.walletservice.dto.ClientDto;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientDtoCreatedEvent extends Event<ClientDto> {

}
