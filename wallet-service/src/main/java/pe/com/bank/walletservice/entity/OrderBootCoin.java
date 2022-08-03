package pe.com.bank.walletservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.bank.walletservice.dto.DebitDto;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "orderBootCoin")
public class OrderBootCoin {
    @Id
    private String id;
    private Integer phoneNumber;
    private Double subTotalPrice;
    private Double totalShippingCost;
    private String accountNumber;
    private Boolean status;
    private PayType payType;
    private String IdWallet;
    private DebitDto debitDto;
    private  WalletEntity walletEntity;
}
