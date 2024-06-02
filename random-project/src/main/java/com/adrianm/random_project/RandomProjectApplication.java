package com.adrianm.random_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class RandomProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomProjectApplication.class, args);
	}

}
