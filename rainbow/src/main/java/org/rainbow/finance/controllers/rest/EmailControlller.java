package org.rainbow.finance.controllers.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rainbow.finance.contracts.reponses.EmailResponse;
import org.rainbow.finance.contracts.strategy.FlowStrategy;
import org.rainbow.finance.model.ApplyLoanComand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(method=RequestMethod.POST,value = "sendMail.json",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EmailResponse> sendEmail(@RequestBody ApplyLoanComand command, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ResponseEntity<EmailResponse>(strategy.invokeEmailStrategy(command),HttpStatus.OK);
	}

}
