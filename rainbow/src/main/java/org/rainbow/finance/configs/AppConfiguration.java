package org.rainbow.finance.configs;

import org.rainbow.finance.contracts.mail.MailSender;
import org.rainbow.finance.email.EmailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!dev")
@Configuration
public class AppConfiguration {
	
	@Bean 
	public MailSender mailSender() {
		return new EmailSender();
	}
	
}
