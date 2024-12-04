
public class HighScore {
	private String intials;
	private int highScore;
	
	public HighScore() {
		super();
		this.intials = "";
		this.highScore = 0;
	}
	
	public HighScore(String intials, int highScore) {
		super();
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
	
	
}
