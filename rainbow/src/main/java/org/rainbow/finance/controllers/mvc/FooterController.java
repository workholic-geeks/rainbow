package org.rainbow.finance.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FooterController {

	@GetMapping("/footer")
	public String footer() {
		return "footer";
	}

}
