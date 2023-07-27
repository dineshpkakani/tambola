package com.game;

import com.game.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TambolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TambolaApplication.class, args);
	}

}
