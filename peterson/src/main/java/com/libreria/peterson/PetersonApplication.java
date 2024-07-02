package com.libreria.peterson;

import com.libreria.peterson.infrastructure.principal.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//Escanea Componentes dentro del paquete establecido
@ComponentScan(basePackages = "com.libreria.peterson")
public class PetersonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PetersonApplication.class, args);
	}

	private final Menu menu;

	@Autowired
	public PetersonApplication(Menu menu) {
		this.menu = menu;
	}

	@Override
	public void run(String... args) throws Exception {

		menu.principal();
	}
}
