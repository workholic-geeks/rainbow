package org.rainbow.finance.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MissedCallController {

	@GetMapping("/missedcall.html")
	public String missedcall() {
		return "missedcall";
	}

}
