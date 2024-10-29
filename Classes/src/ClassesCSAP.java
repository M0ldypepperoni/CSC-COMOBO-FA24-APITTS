import java.util.Scanner;

public class ClassesCSAP {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CourseAP course = new CourseAP();
		CourseAP course2 = new CourseAP("CBT103601", 5, 20, "CT103", 4);

		classInfo(course);
		System.out.println(course);
		System.out.println();
		System.out.println(course2);
	}

	public static void classInfo(CourseAP course1) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please input course number: ");
		course1.setCourseNumber(input.next());
		System.out.println("Please input amount of Students: ");
		course1.setStudents(input.nextInt());
		System.out.println("Please input maxium amount of allowed students: ");
		course1.setMaxStudents(input.nextInt());
		System.out.println("Please input Room: ");
		course1.setRoom(input.next());
		System.out.println("Please input num of credits: ");
		course1.setCredits(input.nextInt());
	}

}
