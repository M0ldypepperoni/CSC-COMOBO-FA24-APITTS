
public class OnlineCourse extends CourseAP {
	private String email;

	public OnlineCourse(String courseNumber, int students, int maxStudents, int credits, String email) {
		super(courseNumber, students, maxStudents, credits);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "OnlineCourse\n" + super.toString() + "\nemail: " + email ;
	}
	
	
}
