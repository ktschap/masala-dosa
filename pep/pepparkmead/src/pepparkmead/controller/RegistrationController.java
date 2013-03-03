package pepparkmead.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import pepparkmead.IMsgFormatter;
import pepparkmead.IPEPDataMgr;
import pepparkmead.ISender;
import pepparkmead.data.GlobalConfig;
import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;
import pepparkmead.data.Vendor;
import pepparkmead.util.Util;

@Controller
public class RegistrationController {
	
	private static final Logger log = Logger.getLogger(RegistrationController.class.getName());

	private IPEPDataMgr dataMgr;
	private ISender sender;
	private IMsgFormatter msgFormat;
	
	@RequestMapping(method = RequestMethod.POST, value="/Register.do")
	public String registerNow(HttpEntity<byte[]> requestEntity,
			@ModelAttribute("registration") Registration reg, 
			@RequestParam("chosenClasses") String chosenClasses,
			ModelMap model) {
		GlobalConfig conf = dataMgr.getConfig();
		reg.setSemesterName(conf.getCurrentSemester());
		logRegInfo(requestEntity, reg, chosenClasses);
		
		List<PEPClass> classes = addClasses(reg, chosenClasses);
		Set<String> ccEmails = null;
		if (conf.getMailVendor()) {
			ccEmails = getCCEmails(classes);
		}
		dataMgr.save(reg);
		String msg = msgFormat.registrationMsg(reg, classes, conf.getCurrentSemester());
		sender.send(reg.getStudentEmail(), ccEmails,"ParkmeadPEP@gmail.com", "New PEP registration!", msg);
		return "Semesters";
	}

	private Set<String> getCCEmails(List<PEPClass> classes) {
		Set<String> emails = new HashSet<String>();
		for (PEPClass c : classes) {
			Long vID = c.getVendorId();
			String ve = getVendorEmail(vID);
			if (ve == null) {
				log.severe("No contact email for vendor: " + vID);
				continue;
			}
			emails.add(ve);	
			log.info("Added vendor email: " + ve);
		}
		return emails;
	}

	private String getVendorEmail(Long vID) {
		List<Vendor> vlist = dataMgr.getAllVendors();
		for (Vendor v : vlist) {
			if (v.getID().equals(vID.toString())) {
				return v.getContactEmail();
			}
		}
		return null;
	}

	private String getAppEngineHeader(HttpEntity<byte[]> re, String p) {
		if (re == null) return null;
		return re.getHeaders().getFirst("X-AppEngine-" + p);
	}

	private void logRegInfo(HttpEntity<byte[]> requestEntity, Registration reg, String chosenClasses) {
		String country = getAppEngineHeader(requestEntity, "Country");
		String region = getAppEngineHeader(requestEntity, "Region");
		String city = getAppEngineHeader(requestEntity, "City");
		StringBuilder sb = new StringBuilder(reg.getStudentNameFirst());
		sb.append(" ").append(reg.getStudentNameLast()).append(" registering for ").append(chosenClasses);
		sb.append(", semester: ").append(reg.getSemesterName());
		addParamToString(city, sb);
		addParamToString(region, sb);
		addParamToString(country, sb);
		log.info(sb.toString());		
	}

	private void addParamToString(String s, StringBuilder sb) {
		if (!Util.isEmpty(s))
			sb.append(" : ").append(s);
	}

	private List<PEPClass> addClasses(Registration reg, String chosenClasses) {
		List<PEPClass> retClasses = new ArrayList<PEPClass>();
		String[] cl = chosenClasses.split("___");
		for (String c : cl) {
			if (c == null || c.length() == 0)
				continue;
			Long classID = Long.valueOf(c);
			addClassIDIfValid(reg, retClasses, classID);
		}
		return retClasses;
	}

	private void addClassIDIfValid(Registration reg,
			List<PEPClass> retClasses, Long classID) {
		PEPClass pclass = dataMgr.getClass(classID);
		if (pclass == null)
			log.severe("can't find class ID: " + classID);
		else {				
			reg.addClassID(classID);
			retClasses.add(pclass);
		}
	}

	public void setDataMgr(IPEPDataMgr m) {
		dataMgr = m;
	}
	
	public void setMessageFormatter(IMsgFormatter f) {
		msgFormat = f;
	}
	
	public void setMessageSender(ISender s) {
		sender = s;
	}
	

}
