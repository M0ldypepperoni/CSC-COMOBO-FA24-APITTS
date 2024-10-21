import java.util.Scanner;

public class Circle {
	
	public static double diaCalc(double rads) {
		double num =  2.0 * rads;
		return num;
	}
	
	public static double aCalc(double rads) {
		double num = Math.PI * Math.pow(rads, 2.0);
		return num;
	}
	
	public static double cirCalc(double rads) {
		double num = 2.0 * Math.PI * rads;
		return num;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double rad = 0.0;
		
		System.out.println("Please input a radius: ");
		rad = input.nextDouble();
		
		double dia = diaCalc(rad);
		double area = aCalc(rad);
		double circum = cirCalc(rad);
		
		System.out.print("Diameter: ");
		System.out.printf("%.2f%n", dia);
		System.out.print("Area: ");
		System.out.printf("%.2f%n", area);
		System.out.print("Circumfrence: ");
		System.out.printf("%.2f%n", circum);
	}

}
