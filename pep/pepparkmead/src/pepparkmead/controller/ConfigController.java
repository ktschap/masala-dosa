package pepparkmead.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pepparkmead.IDataMgr;
import pepparkmead.data.GlobalConfig;

@Controller
@RequestMapping("/admin/Config.do")
public class ConfigController {

	private static final Logger log = Logger.getLogger(ClassAdminController.class.getName());
	private IDataMgr dataMgr;
	
    @RequestMapping(method = RequestMethod.GET)
    public String getConfigPage(ModelMap model) throws Exception {
    	model.put("config", dataMgr.getConfig());
		return "GlobalConfig";
	}

    @RequestMapping(method = RequestMethod.POST)
    public String saveConfig(@ModelAttribute("config") GlobalConfig conf, ModelMap model) throws Exception {
    	log.info("Saving new config: " + conf.toString());
    	dataMgr.save(conf);
		return "GlobalConfig";
	}
    
    public void setDataMgr(IDataMgr m) {
		dataMgr = m;
	}

}
