package pe.com.bank.clientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.bank.clientservice.dto.MovementDto;
import pe.com.bank.clientservice.service.ClientService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/movements-client")
public class MovementReportController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/search/{documentNumber}")
    public Flux<MovementDto> getTenEndMovements(@PathVariable Integer documentNumber){
        return clientService.getTenEndMovements(documentNumber);
    }
}
