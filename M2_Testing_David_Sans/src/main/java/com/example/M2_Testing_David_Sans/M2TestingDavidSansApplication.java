package com.example.M2_Testing_David_Sans;

import com.example.M2_Testing_David_Sans.entities.SmartPhones;
import com.example.M2_Testing_David_Sans.repositories.SmartPhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class M2TestingDavidSansApplication implements CommandLineRunner {
	@Autowired
	SmartPhonesRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(M2TestingDavidSansApplication.class, args);


	}

	public void showmenu() {
		System.out.println("Bienvenidos a la APP: ");
		System.out.println("0- Salir: ");
		System.out.println("1- Crear: ");
		System.out.println("2- Ver todos: ");
		System.out.println("3- Buscar: ");
		System.out.println("4- Modificar por Id: ");
		System.out.println("5- Borrar por Id: ");
		System.out.println("6- Borrar todos los registros: ");
		System.out.println("7- Buscar por fabricante: ");
		System.out.println("8- Buscar por precio menor que: ");


	}
public void subMenuBuscar() {
	System.out.println("0- Volver atrás ");
	System.out.println("1- Buscar por Id: ");
	System.out.println("2- Buscar por fabricante: ");
	System.out.println("3- Buscar por precio menor que: ");
}


	@Override
	public void run(String... args) throws Exception {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			showmenu();
			try {
				int opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion == 0) {
					System.out.println("Hasta la próxima");
					break;
				} else if (opcion == 1) {
					System.out.println("Introduce el fabricante");
					String manufacturer = scanner.nextLine();
					System.out.println("Introduce el modelo");
					String model = scanner.nextLine();
					System.out.println("Introduce la cantidad de Megapixeles");
					Integer mPixel = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Introduce la cantidad de memoria RAM");
					Integer ram = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Introduce el precio");
					Double precio = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("¿El dispositivo dispone de Huella inteligente?");
					Boolean huella= scanner.nextBoolean();

					// 2. Crear el objeto
					SmartPhones telefono = new SmartPhones(null, manufacturer, model, precio, mPixel, huella,ram);

					// 3. Guardar el objeto  en base de datos
					repository.save(telefono);
					System.out.println("Smartphone creado correctamente");

				}else if (opcion == 2) {


				}
				else if (opcion == 3) {
					System.out.println("ha elegido la opción buscar: ");

					while (true) {
						scanner = new Scanner(System.in);
						int subOpcion = scanner.nextInt();
						scanner.nextLine();
						subMenuBuscar();
						if (subOpcion == 0) {
							System.out.println("volver al menu principal");
							break;
						} else if (subOpcion == 1) {
						}
						else if (subOpcion == 2) {
						}
						else if (subOpcion == 3) {
						}
					}
				}
				else if (opcion == 4) {


				}
				else if (opcion == 5) {


				}
				else if (opcion == 7) {


				}
				else if (opcion == 8) {
					System.out.println("Ha escogido buscar todos por fabricante:");
					String manufact = scanner.nextLine();
				;
					for (SmartPhones smartPhone : repository.findByManufacturerIgnoreCase(manufact)) {
						System.out.println(smartPhone);


					}
				}else if (opcion == 9) {
					System.out.println("Introduzca el precio hasta el que desea buscar: ");
					Double preciotope = scanner.nextDouble();
					List<SmartPhones> phones = repository.findByPriceLessThan(preciotope);
					for (SmartPhones smartPhone : phones) {
						System.out.println(smartPhone);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
