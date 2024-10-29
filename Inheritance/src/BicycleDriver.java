
public class BicycleDriver {

	public static void main(String[] args) {
		Bicycle bike = new Bicycle(12, 0);
		MtBike mtBike = new MtBike(24, 0, 26);	
		
		bike.speedUp(25);
		
		mtBike.speedUp(35);
		mtBike.setHeight(28);
		
		System.out.println(bike);
		System.out.println(bike.honk());
		System.out.println();
		System.out.println(mtBike);
		System.out.println(mtBike.honk());

	}

}
