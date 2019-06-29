package org.rainbow.finance.controllers.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {
	
	@GetMapping("/aboutUs.html")
	public String AboutUs() {
		return "aboutUs";
	}

}

