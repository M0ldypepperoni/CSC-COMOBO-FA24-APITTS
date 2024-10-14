import java.util.Scanner;

public class Nested {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				System.out.printf("%4d", i *j);
			}
			System.out.println();
		}
		System.out.println("Enter the word you would like to spell.");
		String str1 = input.next();
		System.out.println("Enter tiles you have.");
		String str2 = input.next();
		int count = 0;
		boolean match = true;

//		for (int i = 0; i < str1.length(); i++) {
//			count = 0;
//			for (int j = 0; j < str2.length(); j++) {
//				if (str1.charAt(i) == str2.charAt(j)) {
//					count++;
//				}
//			}
//			if (count < 1) {
//				System.out.println("A letter is missing.");
//				match = false;
//			}
//		}
//		
//		if (match) {
//			System.out.println("The letters in the first word\nmatch the letters in the second word");
//		}
		
		while (true) {
			count++;
			if (count == 10) {
				System.out.println("hit 10");
			}
			if (count % 3 == 0) {
				System.out.println(count);
				continue;
			}
			
			if (count == 100) {
				System.out.println("stop");
				break;
			}
		}
	}
}
