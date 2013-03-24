package pepparkmead.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import pepparkmead.IDataMgr;
import pepparkmead.TeacherList;
import pepparkmead.controller.ReportController.ReportItem;
import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;
import pepparkmead.util.Util;

@Controller
public class RegAdminController {

	private static final Logger log = Logger.getLogger(RegAdminController.class.getName());	
	private IDataMgr dataMgr;
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/Registrants.do")
	public String showRegistrants(ModelMap model) {
		List<PEPClass> l = dataMgr.getAllClasses(dataMgr.getConfig().getCurrentSemester());
		List<Registration> registrations = dataMgr.getRegistrationsForClass(null);
		List<ReportItem> ri = Util.loadEmergReportData(l, registrations);
		model.put("regItems", ri);
		return "ReportReg";
	}

	@RequestMapping(method = RequestMethod.GET, value="/admin/DeleteRegistration.do")
	public String unregister(@RequestParam("regID") Long studentID, @RequestParam("clToDelete") Long regToDelete, ModelMap model) {
		Registration r = dataMgr.getRegistration(studentID);
		if (r.isRegisteredFor(regToDelete)) {
			r.removeClassID(regToDelete);
			if (r.countClassIDs() < 1)
				dataMgr.delete(Registration.class, r);
			else
				dataMgr.save(r);			
		}
		else {
			log.severe("Attempting to deregister something that is not registered!");
		}
			
		return showRegistrants(model);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/admin/EditRegistration.do")
	public String editReg(@RequestParam("regID") Long studentID, ModelMap model) {
		Registration r = dataMgr.getRegistration(studentID);
		model.put("regToEdit", r);
		model.put("teachers", TeacherList.TEACHER_LIST);
		return "RegEdit";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/admin/RegSave.do")
	public String saveRegEdits(
			@RequestParam("regID") Long studentID,
			@RequestParam("teacherName") String teacherName, 
			@RequestParam("homePhone") String homePhone, 
			@RequestParam("cellPhone") String cellPhone, 
			@RequestParam("email") String email, 
			ModelMap model) {
		log.entering(this.getClass().getName(), "saveRegEdits", new Object[] { studentID, teacherName, homePhone, cellPhone, email });
		Registration r = dataMgr.getRegistration(studentID);
		r.setStudentTeacher(teacherName);
		r.setStudentEmail(email);
		r.setStudentHomePhone(homePhone);
		r.setStudentCellPhone(cellPhone);
		dataMgr.save(r);
		return showRegistrants(model);
	}
	
	public void setDataMgr(IDataMgr m) {
		dataMgr = m;
	}
}
