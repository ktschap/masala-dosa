package pepparkmead.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pepparkmead.IDataMgr;
import pepparkmead.TeacherList;
import pepparkmead.data.GlobalConfig;
import pepparkmead.data.PEPClass;
import pepparkmead.util.Util;

@Controller
@RequestMapping("/Start.do")
public class RegistrationWizardController {

	private static final Logger log = Logger.getLogger(RegistrationWizardController.class.getName());

	private IDataMgr dataMgr;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMainPage(ModelMap model) throws Exception {
		log.info("loading main page");
		String currentSemester = dataMgr.getConfig().getCurrentSemester();
		List<PEPClass> classes = dataMgr.getAllClasses(currentSemester);
		model.put("classes", classes);
		model.put("teachers", TeacherList.TEACHER_LIST);
		final GlobalConfig config = dataMgr.getConfig();
		model.put("regOn", config.getRegistrationOn());
		model.put("regClosedMsg", config.getRegistrationClosedMessage());
		log.info("logging on form model: " + model.get("regOn"));
		model.put("semesterFriendlyDescription", Util.getFriendlySemesterString(currentSemester));
		return "index";
	}
	
	public void setDataMgr(IDataMgr m) {
		dataMgr = m;
	}
}
