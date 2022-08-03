package pe.com.bank.movementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "movement")
public class MovementEntity {

    @Id
    private String id;
    private Date movementDate;
    private String movementType;
    private Integer movementNumber;
    private Double amount;
    private String accountNumber;
    private Integer idAccount;
    private Integer documentNumber;
    private Integer accountNumberReference;
    private Integer phoneNumber;
}
