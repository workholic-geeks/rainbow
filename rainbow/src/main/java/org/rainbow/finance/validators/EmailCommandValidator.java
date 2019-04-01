package org.rainbow.finance.validators;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.properties.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@Qualifier("emailValidator")
public class EmailCommandValidator implements Validator {

	@Autowired
	@Qualifier("propertySource")
	private PropertySource propertySource;

	@Override
	public boolean supports(Class<?> clazz) {
		return Command.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Command command = (Command) target;

		System.out.println("Executing validator.");

	}

}
