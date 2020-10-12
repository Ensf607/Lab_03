package courseRegistration;

import java.util.ArrayList;

public class Offering {
	
	private int sectionNum;
	private int sectionCap;
	private Course theCourse;
	private boolean offeringStatus;
	private boolean capReached;
	private ArrayList <Registration> studentList;  //student list
	
	public Offering (int sectionNum, int sectionCap) {
		setSectionNum(sectionNum);
		setSectionCap(sectionCap);
		studentList = new ArrayList <Registration> ();
	}
	public void addRegistration (Registration reg) {
		//We need to add logic to ensure the requirement for the 
		//minimum number of students in a section is met.
	if(studentList.size()<7) {
		offeringStatus=false;		
		
	}
	else {
		offeringStatus=true;
		}
		studentList.add(reg);}
	

	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

	public int getSectionCap() {
		return sectionCap;
	}

	public void setSectionCap(int sectionCap) {
		this.sectionCap = sectionCap;
	}

	public Course getTheCourse() {
		return theCourse;
	}

	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}

	public ArrayList <Registration> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList <Registration> studentList) {
		this.studentList = studentList;
	}
	@Override
	public String toString () {
		String st = "";
		
		st += "Section Number: " + sectionNum + ", Section cap: " + sectionCap + "\n\n";
		st += "Students in this section are:\n\n";
			for (Registration r : studentList) {
				///I need to get this from student list
				st += r.getTheStudent() + ", Grade: " + r.getGrade();
				st += "\n\n";
			}
		return st;
	}
	public boolean isOfferingStatus() {
		return offeringStatus;
	}
	public void setOfferingStatus(boolean offeringStatus) {
		this.offeringStatus = offeringStatus;
	}
	public void removeStudent(String studentName, int studentId) {
		for (int i=0;i<studentList.size();i++) {
			Registration temp =studentList.get(i);
			if((temp.getTheStudent().getStudentName().equals(studentName) )&& (temp.getTheStudent().getStudentId()==studentId))
				studentList.remove(i);
		}
	}
	
	
	

}
