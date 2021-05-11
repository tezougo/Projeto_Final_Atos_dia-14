package br.wrr.Entregavel_2_Fabr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.wrr.Entregavel_2_Fabr.Models")
@SpringBootApplication(scanBasePackages ="br.wrr.Entregavel_2_Fabr" )
public class Entregavel2FabrApplication {

	public static void main(String[] args) {
		SpringApplication.run(Entregavel2FabrApplication.class, args);
	}

}
