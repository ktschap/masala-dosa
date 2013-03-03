package pepparkmead.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pepparkmead.IPEPDataMgr;

@Controller
public class ClassBasedReportController {
	private static final Logger log = Logger.getLogger(ReportController.class.getName());

	private IPEPDataMgr dataMgr;

	public void setDataMgr(IPEPDataMgr m) {
		dataMgr = m;
	}

	@RequestMapping("admin/Reports.do")
	public String chooseReportClass(ModelMap model) {
		return "blah";
	}

}
