package org.rainbow.finance.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/footer")
	public String welcome() {
		return "footer";
	}

}
