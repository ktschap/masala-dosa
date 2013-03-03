package pepparkmead.data;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class PEPClass {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long ID;

	@Persistent
    private String className;
	@Persistent
    private String day;
	@Persistent
    private String dates;
	@Persistent
    private String lowestAllowedGrade;
	@Persistent
    private String highestAllowedGrade;
	@Persistent
    private  String time;
	@Persistent
    private  int fee;
	@Persistent
    private  String fileName;
	@Persistent
	private String notes;
	@Persistent
	private String semesterName;
	@Persistent
	private int minStudents;
	@Persistent
	private int maxStudents;
	@Persistent
	private String room;
	@Persistent
	private Long vendorId;
	@Persistent
    private String liaison;
	@Persistent
    private String liaisonEmail;
	@Persistent
    private String liaisonPhone;
	@Persistent
    private  String feeString;
	@Persistent
    private String teacher;
	@Persistent
    private String teacherEmail;
	@Persistent
    private String teacherPhone;

	public void setClassName(String t) {
		className = t;
	}
	
	public void setDay(String d) {
		day = d;
	}
	
	public void setDates(String d) {
		dates = d;
	}
	
	public void setNotes(String n) {
		notes = n;
	}
	
	public void setLowestAllowedGrade(String gr) {
		lowestAllowedGrade = gr;
	}
	
	public void setHighestAllowedGrade(String gr) {
		highestAllowedGrade = gr;
	}

	public String getClassName() {
		return className;
	}

	public String getDay() {
		return day;
	}

	public String getDates() {
		return dates;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHighestAllowedGrade() {
		return highestAllowedGrade;
	}

	public String getLowestAllowedGrade() {
		return lowestAllowedGrade;
	}

	public String getNotes() {
		return notes;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getSemester() {
		return semesterName;
	}

	public void setSemester(String semester) {
		this.semesterName = semester;
	}

	public int getMinStudents() {
		return minStudents;
	}

	public void setMinStudents(int minStudents) {
		this.minStudents = minStudents;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getLiaison() {
		return liaison;
	}

	public void setLiaison(String liaison) {
		this.liaison = liaison;
	}

	public String getLiaisonEmail() {
		return liaisonEmail;
	}

	public void setLiaisonEmail(String liaisonEmail) {
		this.liaisonEmail = liaisonEmail;
	}

	public String getLiaisonPhone() {
		return liaisonPhone;
	}

	public void setLiaisonPhone(String liaisonPhone) {
		this.liaisonPhone = liaisonPhone;
	}

	public String getFeeString() {
		return feeString;
	}

	public void setFeeString(String feeString) {
		this.feeString = feeString;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}
}
