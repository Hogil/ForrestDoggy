package forrest.controller.sy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("stpback")
public class StayParKBackMainController {
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String stpMain() {
		return "thymeleaf/backOfficePage/html/stp_manager/stp_backMain";
	}
}
