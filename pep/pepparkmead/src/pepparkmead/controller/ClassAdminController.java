package pepparkmead.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import pepparkmead.IDataMgr;
import pepparkmead.data.PEPClass;

@Controller
public class ClassAdminController {

	private static final String CLASS_EDIT = "ClassEdit";
	private static final String CLASS_LISTING = "ClassList";
	
	private static final Logger log = Logger.getLogger(ClassAdminController.class.getName());
	private IDataMgr dataMgr;
	
	@RequestMapping("/admin/ClassEdit.do")
	public String loadClassEdit(@RequestParam("classToEdit") String classToEdit, ModelMap model) throws Exception {
		if (classToEdit != null && classToEdit.length() > 0)
			addClassToModel(classToEdit, model);
		addClassAdminCommon(model);
        return CLASS_EDIT;
	}

	@RequestMapping("/admin/ClassDelete.do")
	public String deleteClass(@RequestParam("classToDelete") String classToDelete, ModelMap model) throws Exception {
		if (classToDelete != null && classToDelete.length() > 0) {
			dataMgr.delete(PEPClass.class, Long.valueOf(classToDelete));
			Thread.sleep(2000);
		}
		else
			log.severe("Invalid class id passed to class delete: " + classToDelete);
        return CLASS_LISTING;
	}

	@RequestMapping("/admin/ClassAdd.do")
	public String loadClassAdd(ModelMap model) throws Exception {
		addClassAdminCommon(model);
        return CLASS_EDIT;
	}

	@RequestMapping("/admin/ClassList.do")
	public String listClasses(ModelMap model) throws Exception {
		List<PEPClass> classes = dataMgr.getAllClasses(dataMgr.getConfig().getCurrentSemester());
		model.put("classes", classes);		
        return CLASS_LISTING;
	}

	@RequestMapping("/admin/ClassSave.do")
	public String saveClass(@ModelAttribute("pepclass") PEPClass cl, ModelMap model) throws Exception {
		log.info("Modifying/creating class: "  + cl.getClassName() + "/" + cl.getSemester());
		dataMgr.addClass(cl);
		return listClasses(model);
	}

	private void addClassAdminCommon(ModelMap model) {
		addVendorsToModel(model);
		addUploadedFilesToModel(model);
	}

	private void addUploadedFilesToModel(ModelMap model) {
		model.put("uploadedFileList", dataMgr.getAllUploads());		
	}

	private void addVendorsToModel(ModelMap model) {
		model.put("vendorList", dataMgr.getAllVendors());		
	}

	public void setDataMgr(IDataMgr m) {
		dataMgr = m;
	}
	
	private void addClassToModel(String classID, ModelMap model) {
		PEPClass cl = dataMgr.getClass(Long.valueOf(classID));
		model.put("classToEdit", cl);		
	}	
}
