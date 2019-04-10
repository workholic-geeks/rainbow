package org.rainbow.finance.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmiCalculator {
		
	@GetMapping("/emiCalculator.html")
	public String renderCalCulator() {
		return "emiCalculator";
	}
	
}
