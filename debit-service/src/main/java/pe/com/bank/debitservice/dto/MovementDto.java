package pe.com.bank.debitservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovementDto {
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
