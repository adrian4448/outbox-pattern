package com.adrianm.scheduler_outbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = { "org.adrianm.model", "com.adrianm.scheduler_outbox" })
@EnableJpaRepositories({ "org.adrianm.model.repository" })
@EntityScan({ "org.adrianm.*", "com.adrianm.scheduler_outbox.*" })
public class SchedulerOutboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerOutboxApplication.class, args);
	}

}
