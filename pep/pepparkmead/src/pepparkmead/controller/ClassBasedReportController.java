package pepparkmead.controller;


import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pepparkmead.IPEPDataMgr;

//@Controller
//@RequestMapping("/admin/FileUpload.do")
public class ClassBasedReportController {
	private static final Logger log = Logger.getLogger(ClassBasedReportController.class.getName());

	private IPEPDataMgr dataMgr;

	public void setDataMgr(IPEPDataMgr m) {
		dataMgr = m;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String chooseReportClass(ModelMap model) {
		log.info("Entering FileUpload.do handler");
		return "Experimental";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String fileUpload(ModelMap model) {
		return "Experimental";
	}

}
