import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Student {
	private String fName, lName, sNum;
	private String filePath = "C:\\Users\\S03090733\\CSC-COMOBO-FA24-APITTS\\Classes\\newCourse.txt";
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
	public void readFrom() {
		Scanner input = new Scanner(System.in);
		String courseType = "";
		String courseNum = "";
		int stuNum = 0;
		int stuMax = 0;
		int cred = 0;
		String lastString = "";
		try {
			Scanner fileIn = new Scanner(new File(filePath));
			while(fileIn.hasNext()) {
				System.out.println("what type of course is this");
				courseType = input.next();
				courseNum = fileIn.next();
				stuNum = fileIn.nextInt();
				stuMax = fileIn.nextInt();
				cred = fileIn.nextInt();
				lastString = fileIn.next();
				if (courseType.contains("online") || courseType.contains("Online") || courseType.contains("onlineCourse") ||  courseType.contains("OnlineCourse")) {
				CourseAP course3 = new OnlineCourse(courseNum, stuNum, stuMax, cred, lastString);
				courses.add(course3);
				} else if(courseType.contains("in-person") || courseType.contains("In-Person") || courseType.contains("in-personCourse") 
						|| courseType.contains("inperson") || courseType.contains("Inperson") || courseType.contains("inpersonCourse") || courseType.contains("InpersonCourse")) {
					CourseAP course3 = new InPersonCourse(courseNum, stuNum, stuMax, cred, lastString);
					courses.add(course3);
				} else {
					CourseAP course3 = new RemoteCourse(courseNum, stuNum, stuMax, cred, lastString);
					courses.add(course3);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void writeToFile() {
		String outFile = "C:\\Users\\S03090733\\CSC-COMOBO-FA24-APITTS\\Classes\\classes.txt";
		try {
			FileWriter writer = new FileWriter(outFile);

			writer.write("First name: " + fName + "\n");
			writer.write("Last name: " + lName + "\n");
			writer.write("Student Number: " + sNum + "\n");

			for (CourseAP crse : courses) {
				writer.write("\nCourse number: " + crse.getCourseNumber());
				writer.write("\nNumber of students: " + crse.getStudents());
				writer.write("\nMax students: " + crse.getMaxStudents());
				writer.write("\nCredits: " + crse.getCredits());

				if (crse instanceof InPersonCourse) {
					writer.write("\nRoom Number: " + ((InPersonCourse) crse).getRoom() + "\n");
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
