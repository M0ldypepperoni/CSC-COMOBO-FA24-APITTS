
public class CourseAP {
	private String courseNumber;
	private int students;
	private int maxStudents;
	private int credits;

	public CourseAP() {
		this.courseNumber = "";
		this.students = 0;
		this.maxStudents = 0;
		this.credits = 0;
	}

	public CourseAP(String courseNumber, int students, int maxStudents, int credits) {
		this.courseNumber = courseNumber;
		this.students = students;
		this.maxStudents = maxStudents;
		this.credits = credits;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public int getStudents() {
		return students;
	}

	public void setStudents(int students) {
		this.students = students;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}


	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "courseNumber: " + courseNumber + "\nstudents: " + students + "\nmaxStudents: " + maxStudents
			 + "\ncredits: " + credits;
	}

}
