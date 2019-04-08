package org.rainbow.finance.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUsFormController {

	@GetMapping("/contactUSForm.html")
	public String contactUSForm() {
		return "contactUSForm";
	}

}
