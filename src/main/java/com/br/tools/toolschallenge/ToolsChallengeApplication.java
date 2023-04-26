package com.br.tools.toolschallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ToolsChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolsChallengeApplication.class, args);
	}

}
