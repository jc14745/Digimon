
public class Creature {
	String name;
	int speed;
	int attack;
	int defense;
	int HP;
	int level;
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
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
}