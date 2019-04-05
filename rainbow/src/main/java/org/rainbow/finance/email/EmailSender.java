package org.rainbow.finance.email;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.mail.MailSender;
import org.rainbow.finance.contracts.template.TemplateEngine;
import org.rainbow.finance.properties.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EmailSender implements MailSender {

	Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	@Qualifier("mailProperties")
	private MailProperties mailProperties;

	@Autowired
	@Qualifier("rainbowTemplateEngine")
	private TemplateEngine engine;

	@Autowired
	private EmailHelper helper;

	private Session session;

	@Override
	public void sendMail(Command command) {
		try {
			// session.setDebug(true);
			javax.mail.Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mailProperties.getFromMail(), false));
			msg.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(mailProperties.getToMail()));
			msg.addRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("jalajgupta97@gmail.com"));
			msg.addRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("amarpriyadersani@gmail.com"));
			((MimeMessage) msg).setSubject(mailProperties.getMailSubject());
			((MimeMessage) msg).setContent(engine.processHtmlTemplate(mailProperties.getMailBodyFileName(),
					initParam(command), Locale.ENGLISH), "text/html");
			msg.setSentDate(new Date());
			Transport.send((javax.mail.Message) msg);
			logger.info("Message sent..");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error", e);
			helper.writeToFile(command);
		}
	}

	@Override
	public void setSessio(Session session) {
		this.session = session;
	}

	private Map<String, Object> initParam(Command command) {
		Map<String, Object> params = new HashMap<String, Object>(4);
		params.put("personName", command.getName());
		params.put("personContact", command.getPhoneNumber());
		params.put("personEmail", command.getPersonEmail());
		params.put("Comments", command.getComments());
		return params;
	}

}
