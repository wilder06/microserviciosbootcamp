package pe.com.bank.service.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BankServiceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceEurekaServerApplication.class, args);
	}

}
