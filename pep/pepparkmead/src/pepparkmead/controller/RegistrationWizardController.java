package pepparkmead.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pepparkmead.IPEPDataMgr;
import pepparkmead.TeacherList;
import pepparkmead.data.PEPClass;
import pepparkmead.util.Util;

@Controller
@RequestMapping("/Start.do")
public class RegistrationWizardController {

	private static final Logger log = Logger.getLogger(RegistrationWizardController.class.getName());

	private IPEPDataMgr dataMgr;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMainPage(ModelMap model) throws Exception {
		log.info("loading main page");
		String currentSemester = dataMgr.getConfig().getCurrentSemester();
		List<PEPClass> classes = dataMgr.getAllClasses(currentSemester);
		model.put("classes", classes);
		model.put("teachers", TeacherList.TEACHER_LIST);
		model.put("semesterPath", currentSemester);
		model.put("semesterFriendlyDescription", Util.getFriendlySemesterString(currentSemester));
		return "index";
	}
	
	public void setDataMgr(IPEPDataMgr m) {
		dataMgr = m;
	}


}
