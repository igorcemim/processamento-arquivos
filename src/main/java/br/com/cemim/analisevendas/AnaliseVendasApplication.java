package br.com.cemim.analisevendas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class AnaliseVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnaliseVendasApplication.class, args);
	}

}
