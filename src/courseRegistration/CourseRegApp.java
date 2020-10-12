package courseRegistration;

import java.util.ArrayList;
import java.util.Scanner;

//This is my "FrontEnd!"
public class CourseRegApp {
	
	public static void main (String [] args) {
		String name;
		int id;
		Student temp;
		ArrayList<Student> studentList = new ArrayList<Student>();
		CourseCat cat = new CourseCat ();  //This loads the courses from our "DB"
		Course course1 = cat.searchCat("ENGG", 233);
		if (course1 != null) {
			cat.createOffering(course1, 1, 200);
			cat.createOffering(course1, 2, 150);
		}
		Course course2=cat.searchCat("ENSF", 607);
		if (course2 != null) {
			cat.createOffering(course2, 1, 200);
			cat.createOffering(course2, 2, 150);
		}
		Course course3=cat.searchCat("ENGG", 201);
		if (course3 != null) {
			cat.createOffering(course3, 1, 200);
			cat.createOffering(course3, 2, 150);
		}
		Course course4=cat.searchCat("MATH", 211);
		if (course4 != null) {
			cat.createOffering(course4, 1, 200);
			cat.createOffering(course4, 2, 150);
		}
		Course course5=cat.searchCat("ENGG", 501);
		if (course5 != null) {
			cat.createOffering(course5, 1, 200);
			cat.createOffering(course5, 2, 150);
		}
		Course course6=cat.searchCat("MATH", 367);
		if (course6 != null) {
			cat.createOffering(course6, 1, 200);
			cat.createOffering(course6, 2, 150);
		}
		Course course7=cat.searchCat("MATH", 367);
		if (course6 != null) {
			cat.createOffering(course7, 1, 200);
			cat.createOffering(course7, 2, 150);
		}
		boolean check =true;
		System.out.println("Welcome!!");
		
		String menue="1-> Search catalogue courses\n2->Add a Student\n3-> Student List\n4-> Add course to Student\n5-> Remove course from student\n6-> View all courses in catalogue\n7-> View all courses taken by student\n8-> View course offering status( min 8 student)\n9-> Quit";
		Scanner scanner =new Scanner(System.in);
		while(check) {
			System.out.println("\nSelect an option from menue below\n"+menue);
			int ans= scanner.nextInt();
			switch (ans) {
			case 1:
				//ToDo::
				System.out.println("catalogue search method");
				
				break;
			case 2:
				System.out.println("Please enter student name and ID");
				studentList.add(new Student(scanner.next(), scanner.nextInt()));
				break;
			case 3:
				if(studentList.size()>0)
				{for(int i=0;i<studentList.size();i++) {
					System.out.println(studentList.get(i));
				}}
				else
					System.err.println("No students!!");
				break;
			case 5:
				System.out.println("Please enter student name and ID");
				 name= scanner.next();
				 id=scanner.nextInt();
				temp = null;
				for(int i=0;i<studentList.size();i++) {
					if(studentList.get(i).getStudentName().equals(name)&& studentList.get(i).getStudentId()==id) {
						temp=studentList.get(i);
					}
					
				}
				if(temp!=null) {
					System.out.println("Please enter course name, and num");
					temp.deleteCourse(scanner.next(), scanner.nextInt());
									
				}
				else 
					System.err.println("Student Not Found!!");
				break;
			case 4:
				System.out.println("Please enter student name and ID");
				name= scanner.next();
				 id=scanner.nextInt();
				 temp = null;
				for(int i=0;i<studentList.size();i++) {
					if(studentList.get(i).getStudentName().equals(name)&& studentList.get(i).getStudentId()==id) {
						temp=studentList.get(i);
					}
					
				}
				if(temp!=null) {
					System.out.println("Please enter course name, num,and section");
					temp.registerForCourse(cat, scanner.next(), scanner.nextInt(), scanner.nextInt());
					
				}
				else 
					System.err.println("Student Not Found!!");
				break;
			case 6:
				//ToDo::
				System.out.println("print all courses");
				break;
			case 7:
				System.out.println("Please enter student name and ID");
				name= scanner.next();
				 id=scanner.nextInt();
				 temp = null;
				for(int i=0;i<studentList.size();i++) {
					if(studentList.get(i).getStudentName().equals(name)&& studentList.get(i).getStudentId()==id) {
						temp=studentList.get(i);
					}
					
				}
				if(temp!=null) {
					System.out.println(temp.coursesRegisteredTo());
				}
				else 
					System.err.println("Student Not Found!!");
				break;
			case 8:
				//ToDo print all offering status for courses
			break;
			case 9:
				
				check=false;
				break;
			default:
				break;
			}
			
		}
//		Student st1 = new Student ("Sara", 1);
//		Student st2 = new Student ("Joe", 2);
		
	
	
//		System.out.println(myCourse.getOfferingList().get(1).isOfferingStatus());
//		System.out.println(st1.coursesRegisteredTo());
//		System.out.println(st1.getRegList().get(0).getTheOffering().getTheCourse());
//		System.out.println(myCourse.getOfferingList().get(0).getStudentList().get(0).getTheStudent().getStudentName());
	}

}
