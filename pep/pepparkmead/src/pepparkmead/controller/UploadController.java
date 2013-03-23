package pepparkmead.controller;



import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.gmr.web.multipart.GMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.google.appengine.api.datastore.Blob;

import pepparkmead.IPEPDataMgr;
import pepparkmead.data.UploadItem;

@Controller
@RequestMapping(value = "/admin/FileUp.do")
public class UploadController
{
	private static final Logger log = Logger.getLogger(ClassBasedReportController.class.getName());

	private IPEPDataMgr dataMgr;
	public void setDataMgr(IPEPDataMgr mgr) {
		dataMgr = mgr;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(Model model)
	{
		model.addAttribute(new UploadItem());
		return "Experimental";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(UploadItem uploadItem, BindingResult result, ModelMap model)
	{
		if (result.hasErrors())
	    {
			for(ObjectError error : result.getAllErrors())
			{
				String msg = "Error: " + error.getCode() +  " - " + error.getDefaultMessage();
				model.put("errorMsg", msg);
			}
			return "Experimental";
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
					Blob blob = new Blob(b);
					uploadItem.setData(blob);
					dataMgr.save(uploadItem);
				}
			} catch (IOException e) {
				log.severe("Unexpected exception uploading file: " + e.toString());
				e.printStackTrace();
			}
		}
			
			
		return "Experimental";
	}
}
