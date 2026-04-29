package com.aop.application;

import com.aop.application.repository.AccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner myCmd(AccountRepo accountRepo){
		return runner->{
			theAfterReturningAdviceDemo(accountRepo);

		};
	}

	private void theAfterReturningAdviceDemo(AccountRepo accountRepo) {
		accountRepo.findAllAccounts();
		accountRepo.findAllAccounts();
	}

}
