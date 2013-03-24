package pepparkmead.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pepparkmead.IDataMgr;
import pepparkmead.google.UploadItem;

@Controller
@RequestMapping("/details")
public class DownloadController {

	private static final Logger log = Logger.getLogger(DownloadController.class.getName());
	private IDataMgr dataMgr;
	
    @RequestMapping(method = RequestMethod.GET)
    public void download(HttpServletResponse response, ModelMap model, @RequestParam("id") Long id) throws Exception {
    	if (id != null) {
	    	UploadItem i = dataMgr.getUpload(id);
	    	response.addHeader("Content-Type", "application/pdf");
	    	response.getOutputStream().write(i.getData());
	    	return;
    	}
    	log.severe("No file id passed");
//		return "GlobalConfig";
	}

    public void setDataMgr(IDataMgr m) {
		dataMgr = m;
	}
}

