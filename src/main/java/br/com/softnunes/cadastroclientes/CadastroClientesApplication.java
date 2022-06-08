package br.com.softnunes.cadastroclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class CadastroClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroClientesApplication.class, args);
	}

}
