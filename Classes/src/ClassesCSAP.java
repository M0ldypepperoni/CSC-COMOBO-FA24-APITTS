import java.util.Scanner;

public class ClassesCSAP {
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		CourseAP course = new CourseAP();
		CourseAP course2 = new CourseAP("CBT103601", 5, 20, 4);
		InPersonCourse course4 = new InPersonCourse("fgh45341", 3, 4, 7, "BP102");
		
		
		classInfo(course);
//		inClassInfo(course4);
		System.out.println(course);
		System.out.println();
		System.out.println(course2);
		System.out.println(course4);
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
	
	public static void inClassInfo(InPersonCourse inCourse) {
		System.out.println("Please input in person course number: ");
		inCourse.setCourseNumber(input.next());
		System.out.println("Please input amount of Students: ");
		inCourse.setStudents(input.nextInt());
		System.out.println("Please input maxium amount of allowed students: ");
		inCourse.setMaxStudents(input.nextInt());
		System.out.println("Please input num of credits: ");
		inCourse.setCredits(input.nextInt());
		System.out.println("Please input Room: ");
		inCourse.setRoom(input.next());
	}

}
