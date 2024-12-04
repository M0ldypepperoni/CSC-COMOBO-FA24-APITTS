import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HighScore {
	private String intials;
	private String filePath = "C:\\Users\\S03090733\\CSC-COMOBO-FA24-APITTS\\War\\highscored.txt";
	private int highScore;
	
	public HighScore() {
		this.intials = "";
		this.highScore = 0;
	}
	
	public HighScore(String intials, int highScore) {
		this.intials = intials;
		this.highScore = highScore;
	}

	public String getIntials() {
		return intials;
	}

	public void setIntials(String intials) {
		this.intials = intials;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
	public void readFrom() {
		Scanner input = new Scanner(System.in);
		String initial = "";
		int preHighScore = 0;
		try {
			Scanner fileIn = new Scanner(new File(filePath));
			while(fileIn.hasNext()) {
				initial = fileIn.next();
				preHighScore = fileIn.nextInt();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeToFile() {
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(intials);
			writer.write("\n" + highScore);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
