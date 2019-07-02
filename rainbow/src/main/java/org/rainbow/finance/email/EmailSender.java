package org.rainbow.finance.email;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.mail.MailSender;
import org.rainbow.finance.contracts.template.TemplateEngine;
import org.rainbow.finance.properties.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


public class EmailSender implements MailSender {

	Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	@Qualifier("mailProperties")
	private MailProperties mailProperties;

	@Autowired
	@Qualifier("rainbowTemplateEngine")
	private TemplateEngine engine;

	@Autowired
	private EmailHelper helper;

	@Override
	public void sendMail(Command command) {
		try {
			javax.mail.Message msg = javaMailSender.createMimeMessage();
			msg.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(mailProperties.getToMail()));
			if (mailProperties.getToMails() != null)
				for (String rece : mailProperties.getToMails()) {
					msg.setRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(rece));
				}
			((MimeMessage) msg).setSubject(mailProperties.getMailSubject());
			((MimeMessage) msg).setContent(engine.processHtmlTemplate(mailProperties.getMailBodyFileName(),
					initParam(command), Locale.ENGLISH), "text/html");
			msg.setSentDate(new Date());
			javaMailSender.send((MimeMessage) msg);
			logger.info("--Email sent--");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error", e);
			helper.writeToFile(command);
		}
	}

	private Map<String, Object> initParam(Command command) {
		Map<String, Object> params = new HashMap<>(4);
		params.put("personName", command.getName());
		params.put("personContact", command.getPhoneNumber());
		params.put("personEmail", command.getPersonEmail());
		params.put("comments", command.getComments());
		return params;
	}

}
