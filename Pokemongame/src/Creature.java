
public class Creature {
	String name;
	int speed;
	int attack;
	int defense;
	int HP;
	int level;
	Creature left;
	Creature right;
	Creature parent;

	public Creature() {
		
	}
	public Creature(String name) {
		this.name = name;
	}
	public Creature(String name, int speed, int attack, int defense, int HP) {
		this.name = name;
		this.speed = speed;
		this.attack = attack;
		this.defense = defense;
		this.HP = HP;
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
	
	
}
