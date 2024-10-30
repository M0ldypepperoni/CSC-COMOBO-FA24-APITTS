
public class InPersonCourse extends CourseAP {
	private String room;

	public InPersonCourse(String courseNumber, int students, int maxStudents, int credits, String room) {
		super(courseNumber, students, maxStudents, credits);
		this.room = room;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "InPersonCourse\n " + super.toString() + "\nroom: " + room;
	}

	
}
