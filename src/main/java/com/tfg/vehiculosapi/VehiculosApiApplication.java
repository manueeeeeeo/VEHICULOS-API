package com.tfg.vehiculosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehiculosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiculosApiApplication.class, args);
		// Ejemplo endpoint modelos marca https://vehiculos-api.onrender.com/api/modelos/motos?marca=Yamaha
	}

}
