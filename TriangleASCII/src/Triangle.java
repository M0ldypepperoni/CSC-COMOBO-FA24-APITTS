import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char fill = ' ';
		int size = 0;
		char con = 'y';
		
		while (con == 'y') {
			System.out.println("Please enter a number between 1 - 50:");
			while (true) {
				size = input.nextInt();
				if (size > 0 && size <= 50) {
					break;
				} else if (size > 50) {
					System.out.println("Number too big! Enter a num between 1 - 50");
					continue;
				} else {
					System.out.println("Number too small! Enter a num between 1 - 50");
				}
			}
			System.out.println("Enter in fill character:");
			fill = input.next().charAt(0);

			for (int i = 1; i < size; i++) {
				for (int j = size - i; j > 0; j--) {
					System.out.print(" ");
				}
				for (int j = i; j > 0; j--) {
					System.out.print(fill);
					System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println("Would you like to make another triangle?(y/n)");
			con = input.next().charAt(0);
		}
		input.close();
	}
}
