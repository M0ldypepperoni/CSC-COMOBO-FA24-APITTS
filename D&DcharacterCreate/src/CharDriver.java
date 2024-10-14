import java.util.Scanner;

public class CharDriver {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		Character gollum = new Character("Gollum", "Hobbit", 25, 5);
		Character enemy = new Character();
		
		enemy = createChar(enemy);
		
		
		
		System.out.println(gollum);
		System.out.println();
		System.out.println(enemy);
		int dmg = gollum.attack(gollum.getStrength());
		enemy.damage(dmg);
		System.out.println("Damage done:" + dmg );
		System.out.println(enemy);

	}
	
	public static Character createChar(Character chr) {
		
		System.out.println("Enter enemy name:");
		String name = input.next();
		
		chr.setName(name);
		
		System.out.println("Enter enemy type:");
		String type = input.next();
		
		chr.setType(type);
		
		System.out.println("Enter enemy health:");
		int hlth = input.nextInt();
		
		chr.setHealth(hlth);
		
		System.out.println("Enter enemy strength:");
		int strth = input.nextInt();
		
		chr.setStrength(strth);
		return chr;
		
	}

}
