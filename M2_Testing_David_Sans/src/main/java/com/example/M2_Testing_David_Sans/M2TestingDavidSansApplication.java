package com.example.M2_Testing_David_Sans;

import com.example.M2_Testing_David_Sans.repositories.SmartPhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class M2TestingDavidSansApplication implements CommandLineRunner {
	@Autowired
	SmartPhonesRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(M2TestingDavidSansApplication.class, args);


		showmenu();
	}

	public  static void showmenu() {
		System.out.println("Bienvenidos a la APP: ");
		System.out.println("0- Salir: ");
		System.out.println("1- Crear: ");
		System.out.println("2- Ver todos: ");
		System.out.println("3- Buscar por Id: ");
		System.out.println("4- Modificar por Id: ");
		System.out.println("5- Borrar por Id: ");
		System.out.println("6- Borrar todos los registros: ");


	}


	@Override
	public void run(String... args) throws Exception {

	}
}
