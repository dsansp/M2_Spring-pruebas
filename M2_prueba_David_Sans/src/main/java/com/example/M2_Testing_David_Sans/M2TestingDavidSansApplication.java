package com.example.M2_Testing_David_Sans;

import com.example.M2_Testing_David_Sans.entities.SmartPhones;
import com.example.M2_Testing_David_Sans.repositories.SmartPhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class M2TestingDavidSansApplication implements CommandLineRunner {
	@Autowired
	SmartPhonesRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(M2TestingDavidSansApplication.class, args);

		System.out.println("hola mundo");
	}

	public void menuShow() {
		System.out.println("Bienvenidos a la APP: ");
		System.out.println("0- Salir: ");
		System.out.println("1- Crear: ");
		System.out.println("2- Modificar por Id: ");
		System.out.println("3- Buscar: ");
		System.out.println("4- Borrar por Id: ");
		System.out.println("5- Borrar todos los registros: ");
		System.out.println("6- Ver Todos: ");
		System.out.println("7- Buscar por Id: ");
		System.out.println("8- Buscar por fabricante: ");
		System.out.println("9- Buscar por precio menor que: ");
		System.out.println("10- Buscar por Megapixels y por memoria Ram: ");
		System.out.println("11- Buscar por el Modelo: ");
		System.out.println("12- Buscar hasta un precio determinado: ");


	}

//public void subMenuBuscar() {
//	System.out.println("0- Volver atrás ");


//}



	@Override
	public void run(String... args)  throws Exception
	{
	while (true) {
			Scanner scanner = new Scanner(System.in);
			menuShow();
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
					System.out.println("Por favor, introduzca el id del Smartphone que desea modificar");
					Long id = scanner.nextLong();
					scanner.nextLine();
					Optional<SmartPhones> smartPhonesOptional = repository.findById(id);
					if (smartPhonesOptional.isEmpty()){
						System.out.println("No existe el Smartphone solicitado");
					continue;
					}
					SmartPhones smartp=smartPhonesOptional.get();
					System.out.println("Introduce el fabricante (Actual "+ smartp.getManufacturer()+ ") ");
					String manufacturer = scanner.nextLine();
					smartp.setManufacturer(manufacturer);
					System.out.println("Introduce el modelo(Actual "+ smartp.getModel()+ ") ");
					String model = scanner.nextLine();
					smartp.setModel(model);
					System.out.println("Introduce la cantidad de Megapixels (Actual "+ smartp.getPixel()+ ") ");
					Integer mPixel = scanner.nextInt();
					scanner.nextLine();
					smartp.setPixel(mPixel);
					System.out.println("Introduce la cantidad de memoria RAM (Actual "+ smartp.getRam()+") ");
					Integer ram = scanner.nextInt();
					scanner.nextLine();
					smartp.setRam(ram);
					System.out.println("Introduce el precio (Actual "+ smartp.getPrice()+" ) ");
					Double precio = scanner.nextDouble();
					scanner.nextLine();
					smartp.setPrice(precio);
					System.out.println("¿El dispositivo dispone de Huella inteligente? (Actual "+ smartp.getHuella() +") ");
					Boolean huella= scanner.nextBoolean();
					smartp.setHuella(huella);
					repository.save(smartp);
					System.out.println(" Smartphone actualizado correctamente!");

				}
				//else if (opcion == 3) {
				//System.out.println("ha elegido la opción buscar: ");

				//while (true) {
					//	subMenuBuscar();
				//	scanner = new Scanner(System.in);
				//		int subOpcion = scanner.nextInt();
				//		scanner.nextLine();

				//		if (subOpcion == 0) {
				//			System.out.println("volver al menu principal");
				//			break;
					//	}
			else if (opcion == 6) {
							System.out.println("Mostrar todos: ");
							List<SmartPhones> telefono = repository.findAll();
							if (telefono.isEmpty()) {
								System.out.println("No hay Smartphones disponibles.");
							} else {
								System.out.println(telefono);
							}


						} else if (opcion == 7) {
							System.out.println("Introduzca la Id a buscar: ");
							Long id = scanner.nextLong();
							Optional<SmartPhones> smartPhonesOptional = repository.findById(id);
							if (smartPhonesOptional.isPresent()) {
								SmartPhones phones = smartPhonesOptional.get();
								System.out.println(phones);
							} else {
								System.out.println("No existe el smartphone seleccionado");
							}
						} else if (opcion == 8) {
							System.out.println("Introduce un fabricante a buscar: ");
							String manufacturer = scanner.nextLine();

							for (SmartPhones phone : repository.findByManufacturerIgnoreCase(manufacturer))
								System.out.println(phone);


						} else if (opcion == 9) {
							System.out.println("Introduzca el precio de filtrado: ");
							Double price = scanner.nextDouble();
							scanner.next();

							for (SmartPhones phone : repository.findByPriceLessThan(price))
								System.out.println(phone);

						} else if (opcion == 10) {
							System.out.println("Introduzca los megapixels a buscar: ");
							Integer pixel = scanner.nextInt();
							scanner.next();
							System.out.println("Introduzca la cantidad de memoria Ram a buscar: ");
							Integer ram = scanner.nextInt();
							scanner.next();

							for (SmartPhones phone : repository.findBymPixelAndRam(pixel, ram))
								System.out.println(phone);

						} else if (opcion == 11) {
							System.out.println("Introduzca el modelo a buscar: ");
							String model = scanner.next();

							for (SmartPhones phone : repository.findByModelIgnoreCase(model))
								System.out.println(phone);

						} else if (opcion == 12) {
							System.out.println("Introduzca el precio hasta el que desea buscar: ");
							Double preciotope = scanner.nextDouble();
							List<SmartPhones> phones = repository.findByPriceLessThan(preciotope);
							for (SmartPhones smartPhone : phones) {
								System.out.println(smartPhone);

							}
//						} else if (opcion == 4) {


		//				} else if (opcion == 5) {


	//				} else if (opcion == 7) {

	//					} else if (opcion == 8) {

				}


	//				}

	//		}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
