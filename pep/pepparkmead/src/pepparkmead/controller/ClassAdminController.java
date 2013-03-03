package pepparkmead.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import pepparkmead.IPEPDataMgr;
import pepparkmead.data.PEPClass;

@Controller
public class ClassAdminController {

	private static final Logger log = Logger.getLogger(ClassAdminController.class.getName());
	private IPEPDataMgr dataMgr;
	
	@RequestMapping("/admin/ClassEdit.do")
	public String loadClassEdit(@RequestParam("classToEdit") String classToEdit, ModelMap model) throws Exception {
		if (classToEdit != null && classToEdit.length() > 0)
			addClassToModel(classToEdit, model);
		addVendorsToModel(model);
        return "ClassEdit";
	}

	private void addVendorsToModel(ModelMap model) {
		model.put("vendorList", dataMgr.getAllVendors());		
	}

	@RequestMapping("/admin/ClassAdd.do")
	public String loadClassEdit(ModelMap model) throws Exception {
		addVendorsToModel(model);
        return "ClassEdit";
	}

	@RequestMapping("/admin/ClassList.do")
	public String listClasses(ModelMap model) throws Exception {
		List<PEPClass> classes = dataMgr.getAllClasses(dataMgr.getConfig().getCurrentSemester());
		model.put("classes", classes);		
        return "ClassList";
	}

	@RequestMapping("/admin/ClassSave.do")
	public String saveClass(@ModelAttribute("pepclass") PEPClass cl, ModelMap model) throws Exception {
		log.info("Modifying/creating class: "  + cl.getClassName() + "/" + cl.getSemester());
		dataMgr.addClass(cl);
		return listClasses(model);
	}

	public void setDataMgr(IPEPDataMgr m) {
		dataMgr = m;
	}
	
	private void addClassToModel(String classID, ModelMap model) {
		PEPClass cl = dataMgr.getClass(Long.valueOf(classID));
		model.put("classToEdit", cl);		
	}

	
}
