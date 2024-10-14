import java.util.Scanner;

public class TimeDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Time myTime = new Time(9,45,30.0);
		
		//System.out.println(myTime.toString());
		
		Time newTime = new Time();
		System.out.println("please enter a time in 24-hour format"
				+ "i.e 17:00:00.0");
		
		System.out.println("Enter the hour");
		int hour = input.nextInt();
		System.out.println("Enter the minute");
		int min = input.nextInt();
		System.out.println("Enter the seconds");
		double sec = input.nextDouble();
		
		newTime.setHour(hour);
		newTime.setMinute(min);
		newTime.setSeconds(sec);
		Time.convert(newTime);
		System.out.println(newTime);
		System.out.println(myTime);
		System.out.println(myTime.timeDifference(newTime));
		System.out.println(myTime.timeAdds(newTime));
	}
}
