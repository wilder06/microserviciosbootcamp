package pe.com.bank.walletservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClientDto {
    private String fullName;
    private Integer DocumentType;
    private Integer documentNumber;
    private Integer phoneNumber;
    private String address;
    private String clientType;
    private String nameCity;
    private String email;
}
