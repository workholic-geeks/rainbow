package org.rainbow.finance.controllers.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckListQuestionController {
	
	@GetMapping("/checkListQuestion.html")
	public String CheckListQuestion() {
		return "checkListQuestion";
	}

}

