package org.rainbow.finance.controllers.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rainbow.finance.contracts.reponses.EmailResponse;
import org.rainbow.finance.contracts.services.EmailService;
import org.rainbow.finance.model.ApplyLoanComand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	private EmailService emailService;
	
	public EmailResponse sendEmail(@RequestBody ApplyLoanComand command, HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}

}
