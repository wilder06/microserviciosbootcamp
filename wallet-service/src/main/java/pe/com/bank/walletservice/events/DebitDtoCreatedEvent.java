package pe.com.bank.walletservice.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.com.bank.walletservice.dto.ClientDto;
import pe.com.bank.walletservice.dto.DebitDto;

@Data
@EqualsAndHashCode(callSuper = true)
public class DebitDtoCreatedEvent extends Event<DebitDto> {

}
