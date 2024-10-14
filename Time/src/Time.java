
public class Time {

	private int hour;
	private int minute;
	private double seconds;
	// default constructor
	
	public Time() {
		super();
		this.hour = 0;
		this.minute = 0;
		this.seconds = 0;
	}
	
	public Time(int hour, int minute, double seconds) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
	}

	
	//getter and setters
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public double getSeconds() {
		return seconds;
	}

	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}
	
	public static void convert(Time time) {
		if (time.getHour() > 12) time.setHour(time.getHour()- 12);
	}
	
	public int timeDifference(Time that) {
		return Math.abs(this.getHour() - that.getHour());
	}

	public int timeAdds(Time that) {
		 int difH = Math.abs(this.getHour() + that.getHour());
		 int difM = Math.abs(this.getMinute() + that.getMinute());
		 double difS = Math.abs(this.getSeconds() + that.getSeconds());
		 return difH;
	}
	
	//returns string to print
	@Override
	public String toString() {
		String str = "Time is ";
		str += hour;
		str += ":";
		if (minute < 10) str += "0";
		str += minute;
		str += ":";
		if (seconds < 10) str += "0";
		str += seconds;
		
		return str;
	}
}
