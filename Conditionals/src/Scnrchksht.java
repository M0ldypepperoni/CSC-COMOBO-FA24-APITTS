import java.util.Scanner;

public class Scnrchksht {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
//		int numberOne;
//		int numberTwo;
//		int numberThree;
//		
//		System.out.println("Enter 3 numbers.");
//		
//		numberOne = input.nextInt(); 
//		numberTwo = input.nextInt();
//		numberThree = input.nextInt();
//		int big = 0;
//		int mid = 0; 
//		int low = 0;
//		
//		if (numberOne > numberTwo) {
//			System.out.println("numberOne is bigger!");
//		}else if (numberOne == numberTwo) {
//			System.out.println("Both numbers are equal.");
//		} else {
//			System.out.println("numberTwo is bigger!");
//		}
//		
//		if (numberOne > numberTwo && numberOne > numberThree) {
//			big = numberOne;
//		}else if (numberTwo > numberOne && numberTwo > numberThree) {
//			big = numberTwo;
//		} else if (numberThree > numberOne && numberThree > numberTwo) {
//			big = numberThree;
//		}
//		
//		if (numberOne < numberTwo && numberOne < numberThree) {
//			low = numberOne;
//		}else if (numberTwo < numberOne && numberTwo < numberThree) {
//			low = numberTwo;
//		} else if (numberThree < numberOne && numberThree < numberTwo) {
//			low = numberThree;
//		}
//		if (numberOne < big && numberOne > low) {
//			mid = numberOne;
//		}else if (numberTwo < big && numberTwo > low) {
//			mid = numberTwo;
//		} else if (numberThree < big && numberThree > low) {
//			mid = numberThree;
//		}
//		System.out.println(big + " " + mid + " " + low);	
//		
//		String str1;
//		String str2;
//		
//		str1 = input.next();
//		str2 = input.next();
//		
//		char chr1 = str1.charAt(0);
//		char chr2 = str2.charAt(0);
//		
//		if (chr1 > chr2) {
//			System.out.println(str1 + " " + str2);
//		}else if (chr1 == chr2) {
//			if (str1.charAt(1) > str2.charAt(1)) {
//				
//				
//			}
//		}
		  int userNum;
		    int divNum;

		    userNum = input.nextInt();
		    divNum = input.nextInt();

		    userNum = userNum / divNum;
		    System.out.print(userNum); 
		    userNum = userNum / divNum;
		    System.out.print(userNum); 
		    userNum = userNum / divNum;
		    System.out.print(userNum); 
		
	}

}
