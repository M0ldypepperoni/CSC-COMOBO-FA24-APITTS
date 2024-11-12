import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Student {
	private String fName, lName, sNum;

	private ArrayList<CourseAP> courses;

	public Student(String fName, String lName, String sNum) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.sNum = sNum;
		this.courses = new ArrayList<CourseAP>();
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getsNum() {
		return sNum;
	}

	public ArrayList<CourseAP> getCourses() {
		return courses;
	}

	public void addCourse(CourseAP course) {
		courses.add(course);
	}

	public void printCourses() {
		for (CourseAP crse : courses) {
			printDetails(crse);
			System.out.println();
		}
	}

	public void writeToFile() {
		String outFile = "C:\\Users\\drago\\CSC-COMOBO-FA24-APITTS\\Classes\\classes.txt";
		try {
			FileWriter writer = new FileWriter(outFile);

			writer.write("First name: " + fName + "\n");
			writer.write("Last name: " + lName + "\n");
			writer.write("Student Number: " + sNum + "\n");

			for (CourseAP crse : courses) {
				writer.write("\nCourse number: " + crse.getCourseNumber());
				writer.write("\nNumber of students: " + crse.getStudents());
				writer.write("\nMax students: " + crse.getMaxStudents());
				writer.write("\nNumber of students: " + crse.getCredits());

				if (crse instanceof InPersonCourse) {
					writer.write("\nRoom Number:" + ((InPersonCourse) crse).getRoom() + "\n");
				}
				if (crse instanceof OnlineCourse) {
					writer.write("\nEmail: " + ((OnlineCourse) crse).getEmail() + "\n");
				}
				if (crse instanceof RemoteCourse) {
					writer.write("\nWebEx address: " + ((RemoteCourse) crse).getWebEx() + "\n");
				}
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void prepareForFile(CourseAP course) {
		String cN = String.format("Course number: ", course.getCourseNumber());
		String sA = String.format("Number of students: ", course.getStudents());
		String sM = String.format("Max students: ", course.getMaxStudents());
		String cA = String.format("Number of students: ", course.getCredits());

		if (course instanceof InPersonCourse) {
			String rN = String.format("Room Number:", ((InPersonCourse) course).getRoom());
		}
		if (course instanceof OnlineCourse) {
			String tE = String.format("Email: ", ((OnlineCourse) course).getEmail());
		}
		if (course instanceof RemoteCourse) {
			String wL = String.format("WebEx address: ", ((RemoteCourse) course).getWebEx());
		}
	}

	private static void printDetails(CourseAP course) {
		System.out.println("Course number: " + course.getCourseNumber());
		System.out.println("Number of students:" + course.getStudents());
		System.out.println("Max Students:" + course.getMaxStudents());
		System.out.println("Credits:" + course.getCredits());

		if (course instanceof InPersonCourse) {
			System.out.println("Room Number:" + ((InPersonCourse) course).getRoom());
		}
		if (course instanceof OnlineCourse) {
			System.out.println("Email: " + ((OnlineCourse) course).getEmail());
		}
		if (course instanceof RemoteCourse) {
			System.out.println("WebEx address: " + ((RemoteCourse) course).getWebEx());
		}
	}

	@Override
	public String toString() {
		return "Student \nFirst Name:" + fName + "\nLast Name:" + lName + "\nStudent Num:" + sNum;
	}

}
