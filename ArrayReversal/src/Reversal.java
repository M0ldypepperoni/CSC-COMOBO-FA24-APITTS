import java.util.Scanner;

public class Reversal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] reverse = new int[100];
		int count = 0;
		
		System.out.println("Enter values (-1 to Stop)");
		for (int i = 0; i < reverse.length; i++) {
			System.out.print(": ");
			reverse[i] = input.nextInt();
			if (reverse[i] == -1) break;
			count++;
		}
		
		System.out.println("Your values, reversed:");
		for (int j = count - 1; j > -1; --j) {
			System.out.println(reverse[j]); 
			
		}

	}

}
