package com.proyecto3.contactlistapi;

import com.proyecto3.contactlistapi.entity.Contacto;
import com.proyecto3.contactlistapi.repository.contactoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactlistapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(contactoRepository contactoRepositorio){
		return args -> {
			List<Contacto> contactos = Arrays.asList(
					new Contacto("eduardo","eduardo@gmail.com", LocalDate.now()),
					new Contacto("juan","juan@gmail.com", LocalDate.now()),
					new Contacto("jose","jose@gmail.com", LocalDate.now()),
					new Contacto("pedro","pedro@gmail.com", LocalDate.now()),
					new Contacto("pedro","pedro@gmail.com", LocalDate.now())
			);
			contactoRepositorio.saveAll(contactos);
		};
	}

	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
