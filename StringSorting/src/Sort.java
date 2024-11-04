import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] ray;
		int amount = 0;
		String temp = "";
		
		System.out.println("Please input number of strings:");
		amount = input.nextInt();
		ray = new String[amount];
		for (int i = 0; i < ray.length; i++) { 
			System.out.print("type in a word: ");
			ray[i] = input.next();
		}
		
		for(int i = 0; i < ray.length; i++) {
			for (int j = 0; j < ray.length - 1; j++)
			if (ray[j].compareTo(ray[j+1]) > 0) {
				temp = ray[j];
				ray[j] = ray[j + 1];
				ray[j + 1] = temp;
			}
		}
		System.out.println();
		System.out.println("Sorted:");
		
		for (int i = 0; i < ray.length; i++) {
			System.out.println(ray[i]);
		}
		System.out.println();
		for(int i = 0; i < ray.length; i++) {
			for (int j = 0; j < ray.length - 1; j++)
			if (ray[j].compareTo(ray[j+1]) < 0) {
				temp = ray[j];
				ray[j] = ray[j + 1];
				ray[j + 1] = temp;
			}
		}
		
		System.out.println("Reverse Sorted:");
		
		for (int i = 0; i < ray.length; i++) {
			System.out.println(ray[i]);
		}
	}

}
