import java.util.Random;


public class CharDriver {

	private static Random rand = new Random();

	public static void main(String[] args) {

		int dmg;
		Character gollum = new Character("Gollum", "Hobbit", 150, 20);
		Character enemy = new Character("Geoff", "Human", 200, 50);

//		gollum = Character.createChar(gollum);
//		enemy = Character.createChar(enemy);
		gollum.setWeapon("Nails", 25);
		enemy.setWeapon("rock", 40);

		System.out.println(gollum);
		System.out.println();
		System.out.println(enemy);
		while (gollum.getHealth() > 0 && enemy.getHealth() > 0) {

			int whoGoes = rand.nextInt(2);

			if (gollum.getHealth() > 0 && whoGoes == 0) {
				System.out.println("Gollum attacks!");
				dmg = gollum.attack(gollum.getStrength());
				enemy.damage(dmg);
				System.out.println();
				System.out.println("Damage done: " + dmg);
				System.out.println();
				System.out.println(enemy);
			}

			if (enemy.getHealth() > 0 && whoGoes == 1) {
				System.out.println("Geoff attacks!");
				dmg = enemy.attack(enemy.getStrength());
				gollum.damage(dmg);
				System.out.println();
				System.out.println("Damage done: " + dmg);
				System.out.println();
				System.out.println(gollum);
			}

		}
		

	}

}
