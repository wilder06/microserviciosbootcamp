package pe.com.bank.debitservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "debit-account")
public class DebitEntity {

    @Id
    private String id;
    private String accountNumber;
    private Integer limitMovement;
    private BigDecimal balance;
    private String accountType;
    private Boolean accountState;
    private Integer documentNumber;
    private Double maintenanceFee;
    private Integer maxMovement;
    private LocalDate dateExpired;
    private Date date;
    private Integer idCard;
    private String idClient;
    private String priority;
}
