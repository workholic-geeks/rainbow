package org.rainbow.finance.strategy;

import java.util.HashMap;
import java.util.Map;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.reponses.EmailResponse;
import org.rainbow.finance.contracts.services.EmailService;
import org.rainbow.finance.contracts.strategy.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("emailStrategy")
public class EmailStrategy implements Strategy<EmailResponse, Command> {

	@Autowired
	@Qualifier("emailService")
	private EmailService emailService;

	@Override
	public EmailResponse invokeStrategy(Command command) throws Exception {
		emailService.sendMessage(command);
		return new EmailResponse() {
			@Override
			public Object getResponse() {
				Map<Object, Object> response = new HashMap<Object, Object>(1);
				response.put("result", "success");
				return response;
			}
		};
	}

}
