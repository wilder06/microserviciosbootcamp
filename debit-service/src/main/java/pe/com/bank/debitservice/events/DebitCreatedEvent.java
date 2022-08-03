package pe.com.bank.debitservice.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.com.bank.debitservice.entity.DebitEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class DebitCreatedEvent extends Event<DebitEntity> {

}
