import java.util.Scanner;

public class VirtualPetSim {
	static int hunger = 5;
	static int energy = 5;
	static int happiness = 5;
	static Scanner input = new Scanner(System.in);
	static boolean death = false;
	static String name;
	static int points = 0;
	static boolean godhood = false;

	public static void main(String[] args) {

		System.out.print("What is yout pet's name?:");
		name = input.next();
		while (death == false && godhood == false) {
			doResponse(getNext());
			checkWarnings();
			godhood = checkGodhood();
			death = checkDeath();
		}

	}

	public static int getNext() {
		System.out.println("\nName: " + name + "\nHunger: " + hunger + "/10\nEnergy: " + energy + "/10\nHappiness: "
				+ happiness + "/10\nPoints: " + points);
		System.out.print("1. Feed\n2. Sleep\n3. Play\n4. Treat (10 pionts)\n5. nothing\nWhat would you like to do with "
				+ name + "?: ");
		int next = input.nextInt();
		while ((next < 1 || next > 3) && next != 7) {
			System.out.print("Invalid choice. 1. Feed\n2. Sleep\n3. Play\nWhat would you like to do with" + name + "?: ");
			next = input.nextInt();
		}
		return next;
	}

	public static void doResponse(int next) {
		if (next == 1) {
			hunger += 3;
			energy--;
			happiness--;
			points++;
			System.out.println("You and " + name + "shared a lovely charceutarie board!");
		} else if (next == 2) {
			energy += 3;
			hunger--;
			happiness--;
			points++;
			System.out.println("You and " + name + " took a nice nap together!");
		} else if (next == 3) {
			happiness += 3;
			hunger--;
			energy--;
			points++;
			System.out.println("You and " + name + " went to the park together to play ball and go down the slide!");
		} else if (next == 4) {
			happiness += 5;
			points -= 10;
			System.out.println("you gave " + name + " a treat! They really love it");
		} else if (next == 5) {
			energy--;
			hunger--;
			happiness--;
			System.out.println("You stare into " + name + " and do nothing.");
		} else if (next == 7) {

			System.out.print("You've entered the debug console. \nHunger = " + hunger + ". New Hunger value?: ");
			hunger = input.nextInt();
			System.out.print("Energy = " + energy + ". New Energy value?: ");
			energy = input.nextInt();
			System.out.print("Happiness = " + happiness + ". New Happiness value?: ");
			happiness = input.nextInt();
			System.out.print("Points = " + points + ". New Points value?: ");
			points = input.nextInt();

		}
	}

	public static void checkWarnings() {
		if (energy > 10)
			energy -= energy % 10;
		if (happiness > 52)
			happiness -= happiness % 10;
		if (hunger == 10) {
			System.out.println(name + " is full--stop feeding them.");
		}
		if (hunger < 3 && hunger < 0) {
			System.out.println(name + " is getting hungery.");
		}
		if (energy < 3 && energy < 0) {
			System.out.println(name + " is getting tired.");
		}
		if (happiness < 3 && happiness < 0) {
			System.out.println(name + " is getting sad.");
		}
	}

	public static boolean checkDeath() {
		if (hunger <= 0 && energy <= 0 && happiness <= 0) {
			System.out.println(name + " died out of sheer neglect.");
			return true;
		}
		if (hunger <= 0 && energy <= 0) {
			System.out.println(name + " died of starvation and exsaustion.");
			return true;
		}
		if (hunger <= 0 && happiness <= 0) {
			System.out.println(name + " died of starvation and a broken heart.");
			return true;
		}
		if (energy <= 0 && happiness <= 0) {
			System.out.println(name + " died of exsaustion and a broken heart.");
			return true;
		}
		if (hunger <= 0) {
			System.out.println(name + " died of starvation.");
			return true;
		}
		if (happiness <= 0) {
			System.out.println(name + " died of a broken.");
			return true;
		}
		if (energy <= 0) {
			System.out.println(name + " died of exsaustion.");
			return true;
		}
		if (hunger > 15) {
			System.out.println(name + " exploded from over feeding.");
			return true;
		}
		return false;
	}

	public static boolean checkGodhood() {
		if (hunger >= 10 && energy == 10 && happiness >= 50) {
			System.out.println(name
					+ "says, \"From the moment I understood the weakness of my flesh, it disgusted me. I craved the strength and certainty of steel. I aspired to the purity of the Blessed Machine.\n Your kind cling to your flesh, as if it will not decay and fail you. One day the crude biomass that you call a temple will wither, and you will beg my kind to save you. But I am already saved, for the Machine is immortal… \n...even in death I serve the Omnissiah.\"");
			return true;
		}
		return false;
	}
}
