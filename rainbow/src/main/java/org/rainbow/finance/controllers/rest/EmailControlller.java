package org.rainbow.finance.controllers.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.reponses.EmailResponse;
import org.rainbow.finance.contracts.strategy.FlowStrategy;
import org.rainbow.finance.model.ApplyLoanComand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller will expose the email functionality.
 * 
 * @author Anish Singh
 *
 */

@RestController
@CrossOrigin
public class EmailControlller {

	@Autowired
	@Qualifier("strategy")
	private FlowStrategy strategy;

	@GetMapping(value = "/sendMail", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmailResponse sendEmail(/* @RequestBody ApplyLoanComand command, */HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Command command = new ApplyLoanComand();
		command.setComments("Hi testing email body format!");
		command.setName("Ajay");
		command.setPhoneNumber(8689698686L);
		command.setPersonEmail("test@testemail.email");
		return strategy.invokeEmailStrategy(command);
	}

}
