package org.rainbow.finance.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CallLogoInAllPageController {

	@GetMapping("/calllogoinallpages.html")
	public String calllogoinallpages() {
		return "calllogoinallpages";
	}

}
