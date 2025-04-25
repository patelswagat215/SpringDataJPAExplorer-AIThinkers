package com.aithinkers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaExplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaExplorerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandlinerunner(String args[]) {
		return runner -> {
			System.out.println("Hello World");
		};
	}
}
