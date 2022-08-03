package pe.com.bank.creditservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "credit-account")
public class CreditEntity {

    @Id
    private String id;
    private String accountNumber;
    private Integer limitMovement;
    private BigDecimal balance;
    private String accountType;
    private Boolean accountState;
    private Integer idCard;
    private Integer documentNumber;
    private Date expiryDate;
    private String priority;
    private String idClient;
}
