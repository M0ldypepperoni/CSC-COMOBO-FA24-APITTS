import java.util.Scanner;

public class Bottles {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int bottles = 0;
		int strt = 0;
		
		System.out.println("Please enter the amount of beer bottles:");
		strt = input.nextInt();
		bottles = strt;
		
		for (int i = strt; i >= 0; i--) {
			if (i == 1) System.out.println(bottles + " bottle of beer on the wall, " + bottles + " bottle of beer.");
			 else System.out.println(bottles + " bottles of beer on the wall, " + bottles + " bottles of beer.");
			bottles--;
			if (bottles == 1) System.out.println("Take one down and pass it around, " + bottles + " bottle of beer on the wall.");
			 else if (i == 0) System.out.println("Go to the store and buy some more, " + strt + " bottles of beer on the wall.");
			 else System.out.println("Take one down and pass it around, " + bottles + " bottles of beer on the wall.");
		}
		input.close();
	}

}
