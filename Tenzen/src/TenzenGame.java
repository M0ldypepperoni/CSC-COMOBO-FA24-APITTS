import java.util.Random;
import java.util.Scanner;

public class TenzenGame {

	public static void main(String[] args) {
		int p1Games = 0;
		int p2Games = 0;
		Scanner scnr = new Scanner(System.in);
		Random rand = new Random();
		boolean river = true;
		boolean ava = true;
		String yn;
		
		while (ava) {
			
			
			while (river) {
				System.out.println("Input Player One Number");
				int p1Num = scnr.nextInt();
				System.out.println("Input Player Two Number");
				int p2Num = scnr.nextInt();
				int p1Score = 0;
				int p2Score = 0;
			
				for (int i = 0; i < 10; i++) {
					int compDie = rand.nextInt(6) + 1;
					if (p1Num == compDie) p1Score++;
					if (p2Num == compDie) p2Score++;
				}
				if (p1Score > p2Score && p1Score >= 10) {
					System.out.println("Player One Lives!");
					p1Games++;
					river = false;
				}
				else if (p2Score > p1Score && p2Score >= 10) {
					System.out.println("Player Two Lives!");
					p1Games++;
					river = false;
					
				}
			}
			System.out.println("Ready for round two? Y/N");
			yn = scnr.next();
			if (yn.charAt(0) == 'y') {
				ava = true;
			}
		}
	}
}
