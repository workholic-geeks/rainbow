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
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@Qualifier("emailStrategy")
public class EmailStrategy implements Strategy<EmailResponse, Command> {

	@Autowired
	@Qualifier("emailValidator")
	private Validator emailValidator;

	@Autowired
	private EmailService emailService;

	@Override
	public EmailResponse invokeStrategy(Command command) throws Exception {
		Errors errors = new org.springframework.validation.BindException(command, "emailCommand");
		if (emailValidator.supports(command.getClass())) {
			emailValidator.validate(command, errors);
		}
		if (!errors.hasErrors()) {
			emailService.sendMessage(command);
		}
		return new EmailResponse() {

			@Override
			public Object getResponse() {
				Map<Object, Object> response = new HashMap<Object, Object>(1);
				if (errors.hasErrors()) {
					response.put("error", errors.getAllErrors());
				} else
					response.put("result", "success");
				return response;
			}
		};
	}

}
