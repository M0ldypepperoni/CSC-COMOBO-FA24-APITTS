import java.util.ArrayList;
import java.util.Scanner;

public class ClassesCSAP {
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<CourseAP> courses = new ArrayList<CourseAP>();
		CourseAP course = new RemoteCourse("CSV109085", 23, 32, 6, "username@example.calls.webex.com");
		CourseAP course2 = new CourseAP("CBT103601", 5, 20, 4);
		CourseAP course4 = new InPersonCourse("FGH45341", 3, 4, 7, "BP102");
		CourseAP norCourse = new OnlineCourse("gw34253", 45, 64, 5, "roihgoha@gmail.com");
		
		courses.add(course);
		courses.add(course2);
		courses.add(course4);
		courses.add(norCourse);
//		classInfo(course);
//		inClassInfo(course4);
//		printDetails(course);
//		System.out.println();
//		printDetails(course2);
//		System.out.println();
//		printDetails(course4);
		
		for (CourseAP crse : courses) {
			printDetails(crse);
			System.out.println();
		}
	}

	public static void classInfo(CourseAP course1) {
		System.out.println("Please input course number: ");
		course1.setCourseNumber(input.next());
		System.out.println("Please input amount of Students: ");
		course1.setStudents(input.nextInt());
		System.out.println("Please input maxium amount of allowed students: ");
		course1.setMaxStudents(input.nextInt());
		System.out.println("Please input num of credits: ");
		course1.setCredits(input.nextInt());
	}
	
	public static void printDetails(CourseAP course) {
		System.out.println("Course number: " + course.getCourseNumber());
		System.out.println("Number of students:" + course.getStudents());
		System.out.println("Max Students:" + course.getMaxStudents());
		System.out.println("Credits:" + course.getCredits());
		
		
		if(course instanceof InPersonCourse) {
			System.out.println("Room Number:" + ((InPersonCourse)course).getRoom());
		} if (course instanceof OnlineCourse) {
			System.out.println("Email: " + ((OnlineCourse)course).getEmail());
		} if (course instanceof RemoteCourse) {
			System.out.println("WebEx address: " + ((RemoteCourse)course).getWebEx());
		}
	}

}
