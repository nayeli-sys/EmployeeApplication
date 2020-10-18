package mx.com.proyecti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Implementa el uso del modulo de spring Boot
//Es una anotacion (meta-anotacion) que incorpora el escaneo de componentes (busca dentro de nuestro proyecto otras clases como dependencias)
//realiza una configuracion automatyica de nuestro servicio web REST

@SpringBootApplication
public class EmployeeRest {

	public static void main(String[] args) {
		//Levanta nuestro servicio web REST
		SpringApplication.run(EmployeeRest.class, args);
		

	}

}
