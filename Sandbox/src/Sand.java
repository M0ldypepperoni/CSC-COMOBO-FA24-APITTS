
import java.util.Scanner;

public class Sand {
	

	public static void main(String args[]) {
		
	Scanner input = new Scanner(System.in);
//	String str = "Hello World!";
//	int len = str.length();
//	String upper = str.toUpperCase();
	
//	System.out.println(str + " is " + len + " characters long.");
//	System.out.println(str + " all caps looks like " + upper);
//	
//	
//	String sub = str.substring(1, 9);
//	String sub2 = str.substring(6);
//    String sub5 = str.substring(7, 9);
//	int num = 13;
//	int num2 = 2;
//	String num3 = "3";
//	String sentence = "We are all \"Students\" so we are all learning.";
//	
//	System.out.println(sentence);
	
	/*System.out.println(sub);
	System.out.println(sub5.concat(str));
	System.out.println(sub2);
	System.out.println(str.charAt(9));
	System.out.println(str.indexOf("or"));
	*/
    double nickels;
    double dimes;
    double quarters;
    double dollars;

    nickels = input.nextFloat();
    dimes = input.nextFloat();
    quarters = input.nextFloat();
    
    nickels =  nickels * 0.05;
    dimes = dimes * 0.1;
    quarters = quarters * 0.25;
    dollars = nickels + dimes + quarters;
    System.out.printf("Amount: $%.2f\n", dollars);

		
	}

}
