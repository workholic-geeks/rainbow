package org.rainbow.finance.email;

import org.rainbow.finance.contracts.mail.MailFactory;
import org.rainbow.finance.contracts.mail.MailSender;
import org.rainbow.finance.properties.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class MailSenderFactory implements MailFactory {

	@Autowired
	@Qualifier("mailProperties")
	private MailProperties emailProps;

	@Autowired
	private MailSender mailSender;


	@Primary
	@Bean("mailFactory")
	@Scope("singleton")
	public MailFactory getInstance() {
		return new MailSenderFactory();
	}

	@Override
	public MailSender getMailSender() {
		return mailSender;
	}


}
