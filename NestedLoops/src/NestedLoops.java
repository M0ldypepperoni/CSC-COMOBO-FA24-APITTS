import java.util.Random;
import java.util.Scanner;

public class NestedLoops {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		int high = 45;
		int low = 5;
		String yn = "";
		int i = 0;
		int j = 0;
		int count3 = 0;
		int maxRuns = 0;
		int sum = 0;
		
		System.out.println("Please input the highest number.");
		high = input.nextInt();
		System.out.println("Please input the lowest number.");
		low = input.nextInt();
		
		
		if (high - low >= 2) {
			System.out.println("How many times would you like to run the program?");
			j = input.nextInt();
			
			for (i = 0; i < j; ++i) {
				int count = 0;
				int count2 = 0;
				int randNum = rand.nextInt(high - low) + low;
				int randNum2 = rand.nextInt(high - low) + low;
				int max = 0;
				int max2 = 0;
				
				while (randNum != randNum2) {
					count++;
					randNum = rand.nextInt(high - low) + low;
					randNum2 = rand.nextInt(high - low) + low;
					System.out.printf("%5d    %4d\n",randNum,randNum2);
	//				if (randNum % 2 != 0 && randNum2 % 2 != 0 && randNum > max && randNum2 > max2) {
	//					max = randNum;
	//					max2 = randNum2;
	//					count2++;
					//}
					
				}
				if (count > maxRuns) {
					maxRuns = count;
				}
				System.out.println("The loop ran " + count + " times until it matched.");
				count3++;
				sum += count;
			}
			double avg = (0.0 + sum) / count3; 
			System.out.println("The max amount of loop runs is: " + maxRuns + " and the average was " + avg);
			System.out.println("Program ran " + count3 + "times.");
		}
	}
}
