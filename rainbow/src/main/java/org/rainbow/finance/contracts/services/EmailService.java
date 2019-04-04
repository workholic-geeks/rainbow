package org.rainbow.finance.contracts.services;

import org.rainbow.finance.contracts.command.Command;

public interface EmailService {

	public void sendMessage(Command comaCommand) throws Exception;

}
