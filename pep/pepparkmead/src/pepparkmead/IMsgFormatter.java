package pepparkmead;

import java.util.List;

import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;

public interface IMsgFormatter {

	public String registrationMsg(Registration reg, List<PEPClass> classes, String semesterSubfolder);
}
