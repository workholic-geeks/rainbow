package org.rainbow.finance.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

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

	@Autowired
	@Qualifier("smtpSession")
	private Session session;

	@Primary
	@Bean("mailFactory")
	@Scope("singleton")
	public MailFactory getInstance() {
		return new MailSenderFactory();
	}

	@Override
	public MailSender getMailSender() {
		mailSender.setSessio(session);
		return mailSender;
	}

	@Bean("smtpSession")
	@Scope("singleton")
	public Session createSession() {

		return Session.getInstance(initMailHostProps(), new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailProps.getFromMail(), emailProps.getPassword());
			}
		});

	}

	private Properties initMailHostProps() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", emailProps.getSmtpAuth());
		props.put("mail.smtp.starttls.enable", emailProps.getStarttlsEnabled());
		props.put("mail.smtp.host", emailProps.getSmtpAddress());
		props.put("mail.smtp.port", emailProps.getSmtpPort());
		return props;
	}

}
