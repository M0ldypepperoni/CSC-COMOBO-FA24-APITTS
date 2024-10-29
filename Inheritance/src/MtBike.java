
public class MtBike extends Bicycle{
	private int seatHeight;

	public MtBike(int gears, int speed, int seatHeight) {
		super(gears, speed);
		this.seatHeight = seatHeight;
	}
	
	public void setHeight(int newHeight) {
		seatHeight = newHeight;
	}

	public String honk() {
		return "Beep-beep!";
	}
	@Override
	public String toString() {
		return "MtBike\n" + super.toString() + "\nHeight: " + seatHeight;
	}
	
	
}
