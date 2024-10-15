
public class Weapon {
	private String weaponName;
	private int addDamage;

	public Weapon() {
		this.weaponName = "";
		this.addDamage = 0;
	}

	public Weapon(String weaponName, int addDamage) {
		this.weaponName = weaponName;
		this.addDamage = addDamage;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public int getAddDamage() {
		return addDamage;
	}

	public void setAddDamage(int addDamage) {
		this.addDamage = addDamage;
	}

	@Override
	public String toString() {
		return "\nWeapon = " + weaponName + "\nAdded Damage= " + addDamage;
	}

}
