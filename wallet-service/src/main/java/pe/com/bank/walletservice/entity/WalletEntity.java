package pe.com.bank.walletservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.bank.walletservice.dto.ClientDto;
import pe.com.bank.walletservice.dto.DebitDto;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "wallet")
public class WalletEntity {
    @Id
    private String id;
    private Date date;
    private Double amount;
    private String idClient;
    private ClientDto client;
    private String numberDocument;
    private DocumentType documentType;
    private String numberPhone;
    private String idCardDebit;
    private DebitDto debitDto;
}
