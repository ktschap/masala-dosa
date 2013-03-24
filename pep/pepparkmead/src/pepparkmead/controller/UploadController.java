package pepparkmead.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import org.gmr.web.multipart.GMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import pepparkmead.IDataMgr;
import pepparkmead.data.PEPClass;
import pepparkmead.google.UploadItem;

@Controller
@RequestMapping()
public class UploadController
{
	private static final Logger log = Logger.getLogger(ClassBasedReportController.class.getName());
	private static final String FLYER_PAGE = "ClassFlyers";

	private IDataMgr dataMgr;
	public void setDataMgr(IDataMgr mgr) {
		dataMgr = mgr;
	}
	
	@RequestMapping(value = "/admin/FileUp.do", method = RequestMethod.GET)
	public String getUploadForm(ModelMap model)
	{
		this.loadCurrentFiles(model);
		model.addAttribute(new UploadItem());
		return FLYER_PAGE;
	}

	@RequestMapping(value = "/admin/FileUp.do", method = RequestMethod.POST)
	public String create(UploadItem uploadItem, BindingResult result, ModelMap model)
	{
		if (result.hasErrors())
	    {
			for(ObjectError error : result.getAllErrors())
			{
				String msg = "Error: " + error.getCode() +  " - " + error.getDefaultMessage();
				model.put("errorMsg", msg);
			}
			return FLYER_PAGE;
	    }
	
		// Some type of file processing...
		System.err.println("Test upload: " + uploadItem.getName());
		GMultipartFile guf = uploadItem.getFileData();
		if (guf.isEmpty()) {
			model.put("errorMsg", "Empty files are not acceptable");
		} else if (guf.getSize() > 1000000) {
			model.put("errorMsg", "Files must be less than 1 MB");
		} else {
			try {
				InputStream is = guf.getInputStream();
				byte[] b = new byte[is.available()];
				int cntRead = is.read(b);
				if (cntRead > 0) {
					uploadItem.setData(b);
					dataMgr.save(uploadItem);
				}
			} catch (IOException e) {
				log.severe("Unexpected exception uploading file: " + e.toString());
				e.printStackTrace();
			}
		}
				
		return getUploadForm(model);
	}
	
	@RequestMapping(value = "/admin/DeleteUpload.do")
	public String deleteUploadedFile(ModelMap model, @RequestParam("id") Long id)
	{
		if (id != null) {
			List<PEPClass> c = dataMgr.getClassesUsingUpload(id);
			if (c.size() > 0) {
				model.put("errorMsg", "Cannot delete a file referenced by existing class " + c.get(0).getClassName());
			} else {
				dataMgr.delete(UploadItem.class, id);
			}
		}
		return this.getUploadForm(model);
	}

	private void loadCurrentFiles(ModelMap m) {
		m.put("dbFiles", dataMgr.getAllUploads());		
	}
}
