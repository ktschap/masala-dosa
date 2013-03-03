package pepparkmead.util;

import java.util.ArrayList;
import java.util.List;

import pepparkmead.controller.ReportController.ReportItem;
import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;

public class Util {
	public static void addRegIfSameClass(ReportItem item, Registration reg) {
		if (isRegisteredForClass(item, reg)) 
			item.regs.add(reg);
	}

	public static boolean isEmpty(String s) {
		return (s == null || s.length() == 0);
	}
	
	public static boolean isRegisteredForClass(ReportItem item, Registration reg) {
		return reg.isRegisteredFor(item.cl.getID());
	}
	
	public static  List<ReportItem> loadEmergReportData(List<PEPClass> l,
			List<Registration> registrations) {
		List<ReportItem> ret = new ArrayList<ReportItem>();
		for (int i=0; i<l.size(); i++) {
			ReportItem item = new ReportItem();
			item.cl = l.get(i);
			for (Registration reg : registrations) {
				addRegIfSameClass(item, reg);
			}
			ret.add(item);
			item.sortRegs();
		}
		return ret;
	}
	
	public static String getFriendlySemesterString(String semester) {
		if (isEmpty(semester) || isEmpty(semester.trim())) {
			return "";
		}
		semester = semester.trim();
		StringBuilder sb = new StringBuilder();
		if (semester.startsWith("W")) {
			sb.append("Winter 20");
		} else if (semester.startsWith("S")) {
			sb.append("Spring 20");			
		} else if (semester.startsWith("F")) {
			sb.append("Fall 20");			
		}
		sb.append(semester.substring(1));
		return sb.toString();
	}

}
