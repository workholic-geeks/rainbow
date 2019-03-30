package org.rainbow.finance.services;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.services.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * This class will e served as Email service factory.
 * 
 * @author Anish Singh
 *
 */

@Configuration
public class EmailServiceFactory implements EmailService {

	@Bean
	@Scope("singleton")
	public EmailService getInstance() {
		return new EmailServiceFactory();
	}

	@Override
	public void sendMessage(Command comaCommand) {
		
	}

}
