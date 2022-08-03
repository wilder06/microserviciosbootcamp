package pe.com.bank.service.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceGatewayApplication.class, args);
	}

}
