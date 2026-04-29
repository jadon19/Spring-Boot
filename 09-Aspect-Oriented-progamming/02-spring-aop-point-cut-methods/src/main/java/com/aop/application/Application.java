package com.aop.application;

import com.aop.application.repository.AccountRepo;
import com.aop.application.repository.MembershipRepo;
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
	public CommandLineRunner myCmd(AccountRepo accountRepo, MembershipRepo membershipRepo){
		return runner->{
			theBeforeAdviceDemo(accountRepo,membershipRepo);

		};
	}

	private void theBeforeAdviceDemo(AccountRepo accountRepo,MembershipRepo membershipRepo) {
		accountRepo.addAccount();
		System.out.println("lets call again! Same method signature with different class");
		membershipRepo.addAccount();
	}
}
