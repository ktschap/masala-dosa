package pepparkmead.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pepparkmead.IPEPDataMgr;
import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;
import pepparkmead.data.Vendor;
import pepparkmead.util.Util;

@Controller
public class ReportController {
	private static final Logger log = Logger.getLogger(ReportController.class.getName());

	private IPEPDataMgr dataMgr;

	@RequestMapping("admin/AttendanceSheet.do")
	public String attendanceSheets(ModelMap model) {
		log.info("Running attendance report");
		List<PEPClass> l = dataMgr.getAllClasses(dataMgr.getConfig().getCurrentSemester());
		List<Registration> registrations = dataMgr.getRegistrationsForClass(null);
		List<ReportItem> ri = loadKeyspotReportData(l, registrations);
		logSize(ri, "Attendance");
		model.put("reportItems", ri);
		return "AttendanceSheets";
	}
	
	@RequestMapping("admin/MasterReport.do")
	public String masterSchedule(ModelMap model) {
		log.info("Running master schedule report");
		List<PEPClass> l = dataMgr.getAllClasses(dataMgr.getConfig().getCurrentSemester());
		List<ReportItem> ri = assembleMasterReportItems(l);
		logSize(ri, "Master");
		model.put("reportItems", ri);
		return "ReportMasterSchedule";
	}

	private void logSize(List<ReportItem> ri, String type) {
		log.info(type + "Report item list of size " + ((ri == null) ? 0 : ri.size()));			
	}

	@RequestMapping("admin/KeyspotReport.do")
	public String keyspotReport(ModelMap model) {
		log.info("Running keyspot report");
		List<PEPClass> l = dataMgr.getAllClasses(dataMgr.getConfig().getCurrentSemester());
		List<Registration> registrations = dataMgr.getRegistrationsForClass(null);
		List<ReportItem> ri = loadKeyspotReportData(l, registrations);
		logSize(ri, "Keyspot");
		model.put("reportItems", ri);
		return "ReportKeyspot";
	}
	
	private List<ReportItem> loadKeyspotReportData(List<PEPClass> l,
			List<Registration> registrations) {
		List<ReportItem> ret = new ArrayList<ReportItem>();
		if (l == null) return ret;
		for (int i=0; i<l.size(); i++) {
			ReportItem item = new ReportItem();
			item.cl = l.get(i);
			item.vendor = dataMgr.getVendor(item.cl.getVendorId());;
			for (Registration reg : registrations) {
				Util.addRegIfSameClass(item, reg);
			}
			item.regCount = (item.regs == null) ? 0 : item.regs.size();
			ret.add(item);
			item.sortRegs();
		}
		return ret;
	}

	
	private ArrayList<ReportItem> assembleMasterReportItems(List<PEPClass> l) {
		ArrayList<ReportItem> ri = new ArrayList<ReportItem>();
		if (l == null) return ri;
		for (PEPClass cl : l) {
			ReportItem i = new ReportItem();
			i.cl = cl;
			log.info("Adding class: " + cl.getClassName());
			Vendor v = dataMgr.getVendor(cl.getVendorId());
			i.vendor = v;
			List<Registration> reg = dataMgr.getRegistrationsForClass(cl.getID());
			i.regCount = (reg == null) ? 0 : reg.size();
			ri.add(i);
		}
		return ri;
	}

	public void setDataMgr(IPEPDataMgr m) {
		dataMgr = m;
	}

	public static class ReportItem {
		public PEPClass cl;
		public Vendor vendor;
		public Integer regCount;
		public List<Registration> regs = new ArrayList<Registration>();
		public PEPClass getCl() { return cl; }
		public Vendor getVendor() { return vendor; }
		public Integer getRegCount() { return  regCount; }
		public List<Registration> getRegs() { return regs; }
		
		public void sortRegs() {
			Collections.sort(regs, new Registration.RegComparator());
		}
	}
}
