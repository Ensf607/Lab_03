package courseRegistration;

import java.util.ArrayList;

public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList <Registration> regList;    //list of course sections
	
	public Student  (String studentName, int studentId) {
		setStudentName (studentName);
		setStudentId (studentId);
		setRegList(new ArrayList <Registration>());
	}
	public void registerForCourse (CourseCat cat, String courseName, int courseNum, int section) {
		Course myCourse = cat.searchCat(courseName, courseNum);
		//Now the student needs to make sure the section exists. and if it does, register!
		//A student registers by:
		//Creating a registration object
		//and calling the \
		if(myCourse!=null) {
		ArrayList<Offering> offerList = myCourse.getOfferingList();//must fix this!!
		
		Offering theOffering = null;
		for(int i=0;i<offerList.size();i++) {
			if(offerList.get(i).getSectionNum()==section)
				{theOffering=offerList.get(i);
				}
		}
		if(theOffering.getStudentList().size()<theOffering.getSectionCap())
		{
		if(regList.size()<6) {
		Registration reg = new Registration ();
		//check if course is already taken by student 
		reg.register(this, theOffering);
		
		}
		else
			{System.err.println("Reached Max number of courses");
			return;
			}}
		else {
			System.err.println("Section cap reached max");
		}
		}
		else
			System.err.println("Course not found!!");
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public ArrayList <Registration> getRegList() {
		return regList;
	}

	public void setRegList(ArrayList <Registration> regList) {
		this.regList = regList;
	}

	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		regList.add(registration);
		
	}
	@Override
	public String toString() {
		String s="";
		s+="Name: "+studentName+"-Student ID: "+studentId;
		return s;}
public String coursesRegisteredTo() {
	String s="Courses List :\n";
	System.err.println(regList.size());
	for(int i=0;i<regList.size();i++) {
		s+=(i+1)+". "+regList.get(i).getTheOffering().getTheCourse().getCourseName()+"-"+regList.get(i).getTheOffering().getTheCourse().getCourseNum()+"- Section: "+regList.get(i).getTheOffering().getSectionNum()+"\n";
		
	}
	return s;
}

public void deleteCourse(String courseName,int courseNum) {
	boolean check=true;
	for(int i=0;i<regList.size();i++) {
		Registration temp =regList.get(i);
		if((temp.getTheOffering().getTheCourse().getCourseName().equals(courseName)) && (temp.getTheOffering().getTheCourse().getCourseNum()==courseNum)) {
			regList.get(i).getTheOffering().removeStudent(this.studentName,this.studentId);
			regList.remove(i);
			check=false;
		}
	}
	if(check) {
		System.err.println("Course not found!!");
		return;
	}
}
}

