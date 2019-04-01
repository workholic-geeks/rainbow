package org.rainbow.finance.email;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.mail.MailSender;
import org.rainbow.finance.properties.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements MailSender {

	Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private MailProperties mailProperties;

	private Session session;

	@Override
	public void sendMail(Command command) {
		try {
			session.setDebug(true);
			javax.mail.Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mailProperties.getFromMail(), false));
			msg.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(mailProperties.getToMail()));
			((MimeMessage) msg).setSubject(mailProperties.getMailSubject());
			((MimeMessage) msg).setContent("Mail Test", "text/html");
			msg.setSentDate(new Date());
			Transport.send((javax.mail.Message) msg);
			logger.info("Message sent..");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception", e);
		}
	}

	@Override
	public void setSessio(Session session) {
		this.session = session;
	}

}
