package org.rainbow.finance.contracts.mail;

import javax.mail.Session;

import org.rainbow.finance.contracts.command.Command;

public interface MailSender {

	public void setSessio(Session session);

	public void sendMail(Command command);

}
