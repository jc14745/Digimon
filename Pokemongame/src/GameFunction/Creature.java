package GameFunction;
/*creates a Creature object that stores the Creature's name, attack, defense, HP, level, and temp health
* a left, right, and parent creature is also created as to easily place in a binary tree when creating the enemy tree class
*/
public class Creature {
	String name;
	int speed, attack, defense, HP, level, tmpHealth;
	Creature left, right, parent;
	boolean used = false;
	public Creature(String name) {
		this.name = name;
	}

	public Creature(String name, int speed, int attack, int defense, int HP, int level) {
		this.name = name;
		this.speed = speed;
		this.attack = attack;
		this.defense = defense;
		this.HP = HP;
		this.level = level;
		this.tmpHealth = HP;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return this.defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHP() {
		return this.HP;
	}

	public void setHP(int hP) {
		this.HP = hP;
	}

	public void setLevel(int level) {
		this.level = level;

	}

	public int getLevel() {
		return this.level;
	}

	public Creature getLeft() {
		return left;
	}

	public void setLeft(Creature left) {
		this.left = left;
		this.parent = this;
	}

	public Creature getRight() {
		return right;
	}

	public void setRight(Creature right) {
		this.right = right;
		this.parent = this;
	}

	public void setTrue() {
		this.used = true;
	}

	public void setFalse() {
		this.used = false;
	}

	public boolean getUsed() {
		return this.used;
	}

	public int getTmpHealth() {
		return this.tmpHealth;
	}
	//tmphealth reprensent the actual health of the pokemon without loosing the data of the base health of the pokemon
	public void setTmpHealth(int tmpHealth) {
		this.tmpHealth = tmpHealth;
	}
	
	public void resetTmpHealth() {
		this.tmpHealth = this.getHP();
	}
	//increments the stats of the player pokemon that won the fight
	public void incrementStats() {
		
		setLevel(level++);
		setAttack(attack++);
		setSpeed(speed+=2);
		setHP(HP+=5);
	}
}
