package courseRegistration;

import java.util.ArrayList;

public class CourseCat {
	
	private ArrayList <Course> courseList;
	
	public CourseCat () {
		courseList = loadFromDB ();
	}

	private static ArrayList<Course> loadFromDB() {
		//In real life course would be loaded for the database or at least some sort of file
		//on disk. 
		
		//So imagine this is being loaded from the database!
		
		ArrayList <Course> imaginaryDB = new ArrayList <Course> ();
		
		imaginaryDB.add(new Course ("ENGG", 233));
		imaginaryDB.get(0).addPrereq(new Course("ENGG", 200));//manualy adding pre-req for course
		imaginaryDB.add(new Course ("ENSF", 607));
		imaginaryDB.get(1).addPrereq(new Course("ENGG", 600));//manualy adding pre-req for course
		imaginaryDB.add(new Course ("ENGG", 201));
		imaginaryDB.get(2).addPrereq(new Course("MATH", 30));//manualy adding pre-req for course
		imaginaryDB.get(2).addPrereq(new Course("MATH", 31));//manualy adding pre-req for course
		imaginaryDB.add(new Course ("MATH", 211));
		imaginaryDB.get(3).addPrereq(new Course("MATH", 30));//manualy adding pre-req for course
		imaginaryDB.get(3).addPrereq(new Course("MATH", 31));//manualy adding pre-req for course
		imaginaryDB.add(new Course ("ENGG", 501));
		imaginaryDB.get(4).addPrereq(new Course("ENGG", 200));//manualy adding pre-req for course
		imaginaryDB.get(4).addPrereq(new Course("ENGG", 233));//manualy adding pre-req for course
		imaginaryDB.add(new Course ("MATH", 367));
		imaginaryDB.get(5).addPrereq(new Course("MATH", 211));//manualy adding pre-req for course
		return imaginaryDB;
	}
	public ArrayList <Course> searchCat (String courseName) {
		ArrayList <Course> foundCourses = new ArrayList <Course>();
		//search for courses that their name matches courseName and add to the 
		//foundCourses array
		for(int i=0;i<courseList.size();i++) {
			if(courseList.get(i).getCourseName().equals(courseName))
				foundCourses.add(courseList.get(i));
		}
		
		return foundCourses;
	}
	public Course searchCat (String courseName, int courseNum) {
		for (Course c: courseList) {
			if (c.getCourseNum() == courseNum && c.getCourseName().equals(courseName)) {
				return c;
			}
		}
		System.err.println("Couse " + courseName + " " + courseNum + " does NOT exist!");
		return null;
	}
	public void createOffering (Course theCourse, int secNum, int secCap) {
		if (theCourse != null) {
			Offering theOffering = new Offering (secNum, secCap);
			theCourse.addOffering(theOffering);
		}
	}

	public ArrayList <Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList <Course> courseList) {
		this.courseList = courseList;
	}
	public void printCat() {
		StringBuffer sb=new StringBuffer();
		sb.append("Courses available:\n\n");
		for (int i=0;i<courseList.size();i++) {
			sb.append((i+1)+"."+courseList.get(i).courseInfo()+"\n\n");
		}
		System.out.println(sb.toString());
	}

	@Override
	public String toString() {
		String s="Summary---\n\n";
		for (int i=0;i<courseList.size();i++) {
				s+=courseList.get(i).toString();	
				}
		return s;
	}

}
