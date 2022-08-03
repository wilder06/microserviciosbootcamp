package pe.com.bank.movementservice.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.com.bank.movementservice.entity.MovementEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class MovementCreatedEvent extends Event<MovementEntity> {

}
