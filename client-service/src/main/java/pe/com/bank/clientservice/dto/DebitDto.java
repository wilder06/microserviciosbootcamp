package pe.com.bank.clientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DebitDto {
    private String id;
    private String accountNumber;
    private Integer limitMovement;
    private Double balance;
    private String accountType;
    private Boolean accountState;
    private Integer idCard;
    private String idClient;
}
