package pe.com.bank.clientservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.bank.clientservice.dto.CardDto;
import pe.com.bank.clientservice.dto.CreditDto;
import pe.com.bank.clientservice.dto.DebitDto;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "client")
public class ClientEntity {

    @Id
    private String id;
    private String fullName;
    private Integer DocumentType;
    private Integer documentNumber;
    private Integer cellNumber;
    private String address;
    private String clientType;
    private String nameCity;
    private String email;
    private List<DebitDto> debit;
    private List<CreditDto> credit;
    private List<CardDto>card;
}
