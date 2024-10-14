import java.util.Scanner;

public class IOChecksheet {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String word;
		int intNum;
		float realNum;
		double biggerRealNum;
		char letter;

		System.out.println("Enter a phrase:");
		word = input.nextLine();

		System.out.println("Here is phrase: " + word);

		/*System.out.println("Enter a number:");
		intNum = input.nextInt();

		System.out.println("Here is number:" + intNum);

		//System.out.println("Enter a real number:");
		//realNum = input.nextFloat();
		realNum = 54634353563398195798347897298787654321.987654391f;
		realNum = realNum + realNum;
		System.out.println("Here is real number:" + realNum);*/

		/*System.out.println("Enter a monetary value:");
		//biggerRealNum = input.nextDouble();
		biggerRealNum = 98787654321.987654391;
		biggerRealNum = biggerRealNum + biggerRealNum;
		System.out.println(biggerRealNum);
		//System.out.printf("$%.2f", biggerRealNum);

		System.out.println("Enter a character:");
		letter = input.next().charAt(0);

		System.out.println("Here is a character:" + letter);*/
	}

}
