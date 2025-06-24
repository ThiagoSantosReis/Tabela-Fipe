package com.fipetable.vehicles;

import com.fipetable.vehicles.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehiclesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal mainApp = new Principal();
		mainApp.showMenu();
	}
}
