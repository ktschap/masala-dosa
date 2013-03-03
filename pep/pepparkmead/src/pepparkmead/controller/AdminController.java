package pepparkmead.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/Admin.do")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAdminPage(ModelMap model) throws Exception {
		return "Admin";
	}

}
