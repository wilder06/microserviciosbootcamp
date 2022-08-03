package pe.com.bank.walletservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "walletBootCoin")
public class WalletBootcoin {

    @Id
    private String id;
    private Double buyRate;
    private Double sellRate;
    private String description;
    private Double amount;
    private String status;

}
