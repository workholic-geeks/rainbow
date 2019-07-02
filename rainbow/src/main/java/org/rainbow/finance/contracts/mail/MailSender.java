package org.rainbow.finance.contracts.mail;

import org.rainbow.finance.contracts.command.Command;

public interface MailSender {

	public void sendMail(Command command);

}
