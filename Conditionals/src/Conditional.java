import java.util.Scanner;

public class Conditional {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int x;
		
		x = input.nextInt();
				
//		if (x > 0) {
//			System.out.println("It's positive.");
//		}
//		else if (x < 0) {
//			System.out.println("It's negative.");
//		}
//		else {
//			System.out.println("It's zero.");
//		}
//		
//		String word = input.next();
//		
//		if (word.length() >= 8) { 
//			if (word.contains("!")) {
//				System.out.println("good password!");
//			}
//		
//		}
//		switch (x) {
//		case 1:
//			word = "one";
//			break;
//		case 2:
//			word = "two";
//			break;
//		case 3:
//			word = "three";
//			break;
//		}
//		System.out.println(word);
//		
//		String food = input.next();
//		
//		switch (food) {
//		case "apple":
//		case "banana":
//		case "cherry":
//			System.out.println("Fruit");
//			break;
//		case "asparagus":
//		case "carrots":
//		case "peas":
//			System.out.println("veggies");
//			break;
//		default: 
//			System.out.println("It's not on the list");
//		}
		boolean inBetween = (x <= 10 || x >= 1);
		if (inBetween) {
			System.out.println("Please enter a number between 1 and 10.");
		}
	}
}
