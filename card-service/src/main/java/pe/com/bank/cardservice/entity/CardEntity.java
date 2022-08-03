package pe.com.bank.cardservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.bank.cardservice.dto.ClientDto;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "card")
public class CardEntity {
    private String id;
    private String accountNumber;
    private Integer creditMaxAmount;
    private String cardNumber;
    private String clientType;
    private ClientDto clientDto;
}
