package pepparkmead;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import pepparkmead.data.GlobalConfig;
import pepparkmead.data.IDbID;
import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;
import pepparkmead.data.Vendor;
import pepparkmead.google.UploadItem;

public class AppDataMgr implements IDataMgr {

	private static GlobalConfig confCache = null;

	public void save(Object o) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(o);
		}
		finally {
			pm.close();
		}	
	}

	/* (non-Javadoc)
	 * @see pepparkmead.IPEPDataMgr#addClassToSemester(java.lang.String, pepparkmead.PEPClass)
	 */
	public void addClass(PEPClass c) {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(c);
		}
		finally {
			pm.close();
		}
	}

	/* (non-Javadoc)
	 * @see pepparkmead.IPEPDataMgr#getAllClasses(java.lang.String)
	 */
	public List<PEPClass> getAllClasses(String semester) {		
		System.out.println("in getAllClasses: " + semester);
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
        	Query q = pm.newQuery(PEPClass.class);
        	q.setFilter("semesterName == semester");
        	q.declareParameters("String semester");
    		List<PEPClass> r = (List<PEPClass>) q.execute(semester);
    		String str = (r==null) ? "null" : Integer.toString(r.size());
    		System.out.println("in getAllClasses: " + str);
    		return r;
        } finally {
            pm.close();
        }
	}
	
	public List<Registration> getRegistrationsForClass(Long classId) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
	    	Query q = pm.newQuery(Registration.class);
	    	List<Registration> l;
	    	if (classId != null) 
	    		l = doFilterRegistrationSearch(classId, q);
	    	else
	    		l = (List<Registration>)q.execute();
	      	l.size();
			return l;
        } finally {
            pm.close();
        }
	}

	private List<Registration> doFilterRegistrationSearch(Long classId, Query q) {
		q.setFilter("classIDs == classId");
		q.declareParameters("Long classId");
		List<Registration> l = (List<Registration>) q.execute(classId);
		return l;
	}

	public List<Vendor> getAllVendors() {		
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
        	Query q = pm.newQuery(Vendor.class);
        	List<Vendor> r = (List<Vendor>) q.execute();
    		String str = (r==null) ? "null" : Integer.toString(r.size());
    		System.out.println("in getAllClasses: " + str);
    		return r;
        } finally {
            pm.close();
        }
	}
	
	public Vendor getVendor(Long ID) {
		return (Vendor)readByID(ID, Vendor.class);
	}
	

	public void delete(Class c, final Long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Transaction tx=pm.currentTransaction();
        try {
        	tx.begin();
        	Object o = pm.getObjectById(c, id);
            pm.deletePersistent(o);
            tx.commit();
        } catch (Exception e) {
        	tx.rollback();
        	throw new RuntimeException(e);
        } finally {
            pm.close();
        }		
	}

	public void delete(Class c, IDbID dbObj) {
		delete(c, dbObj.getID());
	}


	@Override
	public PEPClass getClass(Long ID) {
		return (PEPClass)readByID(ID, PEPClass.class);
	}

	private Object readByID(Long ID, Class c) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
        	return pm.getObjectById(c, ID);
        } finally {
            pm.close();
        }
	}

	@Override
	public Registration getRegistration(Long id) {
		return (Registration)readByID(id, Registration.class);
	}

	public void saveConfig(GlobalConfig c) {
		save(c);
		synchronized(AppDataMgr.class) {
			confCache = c;
		}
	}
	
	@Override
	public GlobalConfig getConfig() {
		synchronized (AppDataMgr.class) {
			if (confCache != null)
				return confCache;
		}

		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
        	return pm.getObjectById(GlobalConfig.class, GlobalConfig.KEY);
        } catch (JDOObjectNotFoundException e) {
        	System.out.println("Creating new config object, S13");
        	GlobalConfig c = new GlobalConfig();
        	c.setMailVendor(false);
        	c.setCurrentSemester("S13");
        	saveConfig(c);
        } finally {
            pm.close();
        }
        return confCache;
	}

	@Override
	public List<UploadItem> getAllUploads() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
        	Query q = pm.newQuery(UploadItem.class);
        	List<UploadItem> r = (List<UploadItem>) q.execute();
    		String str = (r==null) ? "null" : Integer.toString(r.size());
    		System.out.println("in getAll Uploads: " + str);
    		return r;
        } finally {
            pm.close();
        }
		
	}

	@Override
	public UploadItem getUpload(Long id) {
		return (UploadItem)readByID(id, UploadItem.class);
	}

	@Override
	public List<PEPClass> getClassesUsingUpload(Long uploadId) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
	    	Query q = pm.newQuery(PEPClass.class);
	    	if (uploadId != null) { 
	    		q.setFilter("fileId == uploadId");
	    		q.declareParameters("Long uploadId");
	    		List<PEPClass> l = (List<PEPClass>) q.execute(uploadId);
	    		l.size();
	    	}
	    	return new ArrayList<PEPClass>();
        } finally {
            pm.close();
        }
	}
}
