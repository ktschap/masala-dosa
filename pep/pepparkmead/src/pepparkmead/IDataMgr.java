package pepparkmead;

import java.util.List;

import pepparkmead.data.GlobalConfig;
import pepparkmead.data.IDbID;
import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;
import pepparkmead.data.Vendor;
import pepparkmead.google.UploadItem;

public interface IDataMgr {

	public void addClass(PEPClass c);

	public List<PEPClass> getAllClasses(String semester);

	public PEPClass getClass(Long classID);
	
	public void save(Object o);
	
	public List<Vendor> getAllVendors();

	public Vendor getVendor(Long ID); 
	
	public List<UploadItem> getAllUploads();
	
	public UploadItem getUpload(Long id);
	
	public List<Registration> getRegistrationsForClass(Long classId);

	public Registration getRegistration(Long id);

	public void delete(Class c, IDbID dbObj);
	
	public void delete(Class c, Long id);

	public GlobalConfig getConfig();
	
	public void saveConfig(GlobalConfig c);

	List<PEPClass> getClassesUsingUpload(Long uploadId);
	
}