package pe.com.bank.clientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreditDto {
    private String id;
    private String accountNumber;
    private Integer limitMovement;
    private Double balance;
    private String accountType;
    private Boolean accountState;
    private Date expiryDate;
    private Date dateRate;
    private Integer idCard;
    private String idClient;
}
