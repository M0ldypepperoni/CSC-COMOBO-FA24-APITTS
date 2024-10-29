
public class Bicycle {
	private int gears;
	private int speed;
	
	public Bicycle(int gears, int speed) {
		this.gears = gears;
		this.speed = speed;
	}
	
	public void applyBrake(int howMuch) {
		speed -= howMuch;
	}
	
	public void speedUp(int increment) {
		speed += increment;
	}
	
	public String honk() {
		return "Toot-toot!";
	}
	
	public String toString() {
		return ("Number of gears are " + gears +"\nSpeed: " + speed);
	}
}
