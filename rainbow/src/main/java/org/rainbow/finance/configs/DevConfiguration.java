package org.rainbow.finance.configs;

import org.rainbow.finance.contracts.app.AppConfig;
import org.rainbow.finance.contracts.mail.MailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevConfiguration {

	@Bean
	public MailSender mailSender() {
		return (command) -> {
			System.out.println("========Mail sent=====");
		};
	}

	@Bean
	public AppConfig appConfig() {
		return new AppConfig() {

			@Override
			public void initConfig() {
				// TODO Auto-generated method stub

			}

			@Override
			public void destroy() {
				// TODO Auto-generated method stub

			}
		};
	}
}
