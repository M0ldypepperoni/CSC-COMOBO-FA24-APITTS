import java.util.Random;

public class Character {
	
	private Random rand = new Random();
	private String name;
	private String type;
	private int health;
	private int strength;
	
	
	
	public Character() {
		this.name = "";
		this.type = "";
		this.health = 0;
		this.strength = 0;
	}

	public Character(String name, String type, int health, int strength) {
		this.name = name;
		this.type = type;
		this.health = health;
		this.strength = strength;
	}
	
	
	public int attack(int strength) {
		return strength * rand.nextInt(4) + 1;
	}
	
	public void damage(int amount) {
		this.health = this.health - amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Override
	public String toString() {
		return "Character name = " + name + "\nclass = " + type + "\nhealth = " + health + "\nstrength = " + strength;
	}
	
		
	
}
