package org.rainbow.finance.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

	@GetMapping("/map.html")
	public String loadMap() {
		System.out.println("-----------");
		return "map";
	}

}
