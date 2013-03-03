package pepparkmead;

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

public class PEPDataMgr implements IPEPDataMgr {

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
	

	public void delete(Class c, IDbID dbObj) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Transaction tx=pm.currentTransaction();
        try {
        	tx.begin();
        	Object o = pm.getObjectById(c, dbObj.getID());
            pm.deletePersistent(o);
            tx.commit();
        } catch (Exception e) {
        	tx.rollback();
        	throw new RuntimeException(e);
        } finally {
            pm.close();
        }		
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
		synchronized(PEPDataMgr.class) {
			confCache = c;
		}
	}
	
	@Override
	public GlobalConfig getConfig() {
		synchronized (PEPDataMgr.class) {
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
}
