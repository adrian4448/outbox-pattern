package com.adrianm.random_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "org.adrianm.model", "com.adrianm.random_project" })
@EnableJpaRepositories({ "org.adrianm.model.repository", "com.adrianm.random_project.model.repository" })
@EntityScan({ "org.adrianm.*", "com.adrianm.random_project.*" })
@EnableJpaAuditing
public class RandomProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomProjectApplication.class, args);
	}

}
