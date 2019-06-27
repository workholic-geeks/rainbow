package org.rainbow.finance.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoanProductController {
	
	@GetMapping(value="/shortTermLoan.html")
	public String shortTermLoan() {
		return "shortTermLoan.html";
	}
	
	@GetMapping(value="/mediumTermLoan.html")
	public String mediumTermLoan() {
		return "mediumTermLoan.html";
	}
	
	@GetMapping(value="/longTermLoan.html")
	public String longTermLoan() {
		return "longTermLoan.html";
	}
	
	@GetMapping(value="/shortTermSlider.html")
	public String shortTermSlider() {
		return "autoSliderShortTermLoan.html";
	}
	@GetMapping(value="/mediumTermSlider.html")
	public String mediumTermSlider() {
		return "autoSliderMediumTermLoan.html";
	}
	@GetMapping(value="/longTermSlider.html")
	public String longTermSlider() {
		return "autoSliderLongTermLoan.html";
	}
}
