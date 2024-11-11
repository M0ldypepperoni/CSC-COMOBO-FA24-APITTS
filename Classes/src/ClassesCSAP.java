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
		
		
		Student avery = new Student("Avery", "Pitts", "S03090733");
		System.out.println(avery);
//		avery.addCourse(norCourse);
//		avery.addCourse(course4);
//		avery.addCourse(course2);
//		avery.printCourses();
		avery.writeToFile();
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
	


}
