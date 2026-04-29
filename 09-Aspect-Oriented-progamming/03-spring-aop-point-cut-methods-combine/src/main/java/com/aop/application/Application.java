package com.aop.application;

import com.aop.application.repository.AccountRepo;
import com.aop.application.repository.AccountRepoImpl;
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
			theBeforeAdviceDemo(accountRepo);

		};
	}

	private void theBeforeAdviceDemo(AccountRepo accountRepo) {
		accountRepo.addAccount();
		AccountRepoImpl obj = new AccountRepoImpl();
		obj.setName("tanishka");
		obj.setAccountNumber(134442205);
		System.out.println(obj.getName()+obj.getAccountNumber());
	}
}
