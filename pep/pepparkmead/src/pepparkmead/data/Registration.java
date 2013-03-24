package pepparkmead.data;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.TimeZone;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import pepparkmead.AppDataMgr;
import pepparkmead.TeacherList;

@PersistenceCapable
public class Registration implements IDbID {

	private static final String AFTER_CLASS_KEYSPOT = "keyspot";
	private static final String AFTER_CLASS_PICKEDUP = "pickedup";
	private static final String AFTER_CLASS_OTHER = "other";

	private static DateFormat dateFormat;
	static {
		dateFormat = DateFormat.getDateTimeInstance();
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
	}
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long ID;

	@Persistent
	private ArrayList<Long> classIDs = new ArrayList<Long> ();	

	@Persistent
	private String studentNameFirst;

	@Persistent
	private String studentNameLast;

	@Persistent
	private String studentTeacher;

	@Persistent
	private String studentGrade;
	
	@Persistent
	private String studentGuardian;
	
	@Persistent
	private String studentHomePhone;

	@Persistent
	private String studentCellPhone;
	
	@Persistent
	private String studentEmail;
	
	@Persistent
	private String medicineAllergies;
	
	@Persistent
	private String otherAllergies;
	
	@Persistent
	private boolean childcarePolicy;

	@Persistent
	private boolean behaviorPolicy;

	@Persistent
	private boolean specialNeeds;
	
	@Persistent
	private boolean waiverAcknowledgement;

	@Persistent
	private String afterClass;

	@Persistent
	private String pickedUpBy;

	@Persistent
	private String otherInstructions;

	@Persistent
	private String emergencyContactName;

	@Persistent
	private String emergencyContactPhone;

	@Persistent
	private String insuranceCompany;

	@Persistent
	private String insurancePolicyNumber;

	@Persistent
	private String insurancePhone;

	@Persistent
	private String date = dateFormat.format(new Date());

	@Persistent
	private String semesterName;

	public static class RegComparator implements Comparator<Registration> {

		@Override
		public int compare(Registration r1, Registration r2) {
			if (r1 == null || r2 == null)
				throw new NullPointerException("Null Registration objects");
			
			return r1.getStudentNameLast().compareToIgnoreCase(r2.getStudentNameLast());
		}
		
	}
	
	public String getStudentTeacher() {
		return studentTeacher;
	}

	public String getStudentTeacherRoom() {
		return TeacherList.getRoom(this.studentTeacher);
	}

	public void setStudentTeacher(String studentTeacher) {
		this.studentTeacher = studentTeacher;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	public String getStudentGuardian() {
		return studentGuardian;
	}

	public void setStudentGuardian(String studentGuardian) {
		this.studentGuardian = studentGuardian;
	}

	public String getMedicineAllergies() {
		return medicineAllergies;
	}

	public void setMedicineAllergies(String medicineAllergies) {
		this.medicineAllergies = medicineAllergies;
	}

	public String getOtherAllergies() {
		return otherAllergies;
	}

	public void setOtherAllergies(String otherAllergies) {
		this.otherAllergies = otherAllergies;
	}

	public boolean isBehaviorPolicy() {
		return behaviorPolicy;
	}

	public void setBehaviorPolicy(boolean behaviorPolicy) {
		this.behaviorPolicy = behaviorPolicy;
	}

	public boolean isChildcarePolicy() {
		return childcarePolicy;
	}

	public void setChildcarePolicy(boolean childcarePolicy) {
		this.childcarePolicy = childcarePolicy;
	}

	public String getAfterClass() {
		return afterClass;
	}

	public void setAfterClass(String afterClass) {
		this.afterClass = afterClass;
	}

	public boolean isSpecialNeeds() {
		return specialNeeds;
	}

	public void setSpecialNeeds(boolean b) {
		this.specialNeeds = b;
	}

	public boolean isWaiverAcknowledgement() {
		return waiverAcknowledgement;
	}

	public void setWaiverAcknowledgement(boolean waiverAcknowledgement) {
		this.waiverAcknowledgement = waiverAcknowledgement;
	}

	public String getPickedUpBy() {
		return pickedUpBy;
	}

	public void setPickedUpBy(String pickedUpBy) {
		this.pickedUpBy = pickedUpBy;
	}

	public String getOtherInstructions() {
		return otherInstructions;
	}

	public void setOtherInstructions(String otherInstructions) {
		this.otherInstructions = otherInstructions;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getInsurancePhone() {
		return insurancePhone;
	}

	public void setInsurancePhone(String insurancePhone) {
		this.insurancePhone = insurancePhone;
	}

	public ArrayList<Long> getClassIDs() {
		return classIDs;
	}

	public void addClassID(Long id) {
		this.classIDs.add(id);
		System.out.println("added " +id);
	}
	
	public String getStudentHomePhone() {
		return studentHomePhone;
	}

	public void setStudentHomePhone(String studentHomePhone) {
		this.studentHomePhone = studentHomePhone;
	}

	public String getStudentCellPhone() {
		return studentCellPhone;
	}

	public void setStudentCellPhone(String studentCellPhone) {
		this.studentCellPhone = studentCellPhone;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}
	
	public boolean isRegisteredFor(Long classID) {
		if (classID == null) return false;
		
		for (Long l : this.classIDs) {
			if (classID.equals(l))
				return true;
		}		
		return false;		
	}

	public void removeClassID(Long regToDelete) {
		classIDs.remove(regToDelete);
	}

	public int countClassIDs() {
		return classIDs.size();
	}

	public String getStudentNameFirst() {
		return studentNameFirst;
	}

	public void setStudentNameFirst(String studentNameFirst) {
		this.studentNameFirst = studentNameFirst;
	}

	public String getStudentNameLast() {
		return studentNameLast;
	}

	public void setStudentNameLast(String studentNameLast) {
		this.studentNameLast = studentNameLast;
	}

	public String getDate() {
		return date;
	}
	
	public boolean isKeyspotAfterClass() {
		return AFTER_CLASS_KEYSPOT.equalsIgnoreCase(getAfterClass());
	}

	public boolean isPickupAfterClass() {
		return AFTER_CLASS_PICKEDUP.equalsIgnoreCase(getAfterClass());
	}

	public boolean isOtherAfterClass() {
		return AFTER_CLASS_OTHER.equalsIgnoreCase(getAfterClass());
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

}
