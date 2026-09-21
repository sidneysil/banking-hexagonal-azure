package com.sidney.banking.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sidney.banking.account.application.port.out.AccountEventPublisherPort;
import com.sidney.banking.account.application.port.out.AccountRepositoryPort;
import com.sidney.banking.account.application.service.CreateAccountService;

@Configuration
public class AccountConfig {

	@Bean
	CreateAccountService createAccountService(
	        AccountRepositoryPort accountRepositoryPort, 
	 AccountEventPublisherPort accountEventPublisherPort){

	    return new CreateAccountService(
	    		accountRepositoryPort,
                accountEventPublisherPort
                );
	
}
}