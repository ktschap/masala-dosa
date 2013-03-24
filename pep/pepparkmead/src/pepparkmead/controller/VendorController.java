package pepparkmead.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pepparkmead.IDataMgr;
import pepparkmead.data.Vendor;

@Controller
public class VendorController {
	
	private static final Logger log = Logger.getLogger(VendorController.class.getName());

	private IDataMgr dataMgr;

	@RequestMapping("admin/VendorList.do")
	public String getVendors(ModelMap model) {
		model.put("vendors", dataMgr.getAllVendors());
		return "VendorList";
	}

	@RequestMapping("admin/VendorAdd.do")
	public String getAddForm(ModelMap model) {
		return "VendorAdd";
	}

	@RequestMapping("admin/CreateVendor.do")
	public String createOrEditVendor(@ModelAttribute("vendor") Vendor v, ModelMap model) {
		log.info("in createOrEditVendor " + v.getVendorName());
		log.info("in createOrEditVendor " + v.getID());
		dataMgr.save(v);
		return getVendors(model);
	}
	
	@RequestMapping("admin/VendorEdit.do")
	public String editVendor(@RequestParam("vendorToEdit") Long vendorID, ModelMap model) {
		log.info("in edit Vendor " + vendorID);
		Vendor v = dataMgr.getVendor(vendorID);
		model.put("vendor", v);
		return "VendorAdd";
	}
	
	public void setDataMgr(IDataMgr m) {
		dataMgr = m;
	}
		
}
