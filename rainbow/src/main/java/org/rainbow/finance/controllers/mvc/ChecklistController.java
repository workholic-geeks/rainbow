package trunk.rainbow.src.main.java.org.rainbow.finance.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChecklistController {
	@GetMapping("/checklist.html")
	public String checklist() {
		System.out.println("Controller##############################");
		return "checklist";
	}

}
