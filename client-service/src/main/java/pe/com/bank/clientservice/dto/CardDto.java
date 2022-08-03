package pe.com.bank.clientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CardDto {
    private String accountNumber;
    private Integer creditMaxAmount;
    private String cardNumber;
    private String clientType;
}
