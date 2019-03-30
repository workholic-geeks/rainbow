package org.rainbow.finance.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * This class represents welcome controller for rainbow site.
 * 
 * @author Anish Singh
 *
 */
@Controller
public class WelcomeController {

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
