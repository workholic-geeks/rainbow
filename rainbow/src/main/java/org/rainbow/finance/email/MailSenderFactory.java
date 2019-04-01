package org.rainbow.finance.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.rainbow.finance.contracts.mail.MailFactory;
import org.rainbow.finance.contracts.mail.MailSender;
import org.rainbow.finance.properties.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MailSenderFactory implements MailFactory {

	@Autowired
	private MailProperties emailProps;

	@Autowired
	private Session session;

	@Bean
	@Scope("singleton")
	public MailFactory getInstance() {
		return new MailSenderFactory();
	}

	@Override
	public MailSender getMailSender() {

		MailSender sender = new EmailSender();
		sender.setSessio(session);
		return sender;
	}

	@Bean
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
