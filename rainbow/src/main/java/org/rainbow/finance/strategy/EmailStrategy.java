package org.rainbow.finance.strategy;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.reponses.EmailResponse;
import org.rainbow.finance.contracts.strategy.Strategy;

public class EmailStrategy implements Strategy<EmailResponse, Command> {

	@Override
	public EmailResponse invokeStrategy(Command command) throws Exception {
		return null;
	}

}
