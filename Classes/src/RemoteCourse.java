
public class RemoteCourse extends CourseAP {
	private String webEx;

	public RemoteCourse(String courseNumber, int students, int maxStudents, int credits, String webEx) {
		super(courseNumber, students, maxStudents, credits);
		this.webEx = webEx;
	}

	public String getWebEx() {
		return webEx;
	}

	public void setWebEx(String webEx) {
		this.webEx = webEx;
	}

	@Override
	public String toString() {
		return "RemoteCourse\n" + super.toString() + "\nwebEx:" + webEx  ;
	}
	
	

}
