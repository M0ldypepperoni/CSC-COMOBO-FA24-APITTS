import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\S03090733\\CSC-COMOBO-FA24-APITTS\\FileIOC\\items.txt";
		double subtotal = 0;
		double taxes = 0;
		double total = 0;

		try {
			Scanner fileIn = new Scanner(new File(filePath));

			while (fileIn.hasNextDouble()) {
				double value = fileIn.nextDouble();
				subtotal += value;
			}
			taxes = subtotal * 0.0805;
			total = subtotal + taxes;
			System.out.println("Items add to total.");
			System.out.println(subtotal);
			System.out.printf("%.2f\n", taxes);
			System.out.printf("%.2f\n", total);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("File is not there!");
		}

		String outFile = "C:\\Users\\S03090733\\CSC-COMOBO-FA24-APITTS\\FileIOC\\total.txt";
		
		try {
			FileWriter writer = new FileWriter(outFile);
			String line1 = String.format("Your Subtotal is $%.2f\n", subtotal);
			String line2 = String.format("Your tax is $%.2f\n", taxes);
			String line3 = String.format("Your total is $%.2f", total);

			writer.write(line1);
			writer.write(line2);
			writer.write(line3);
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("It broke!");
		}
	}

}
