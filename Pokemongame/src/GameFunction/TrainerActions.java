package GameFunction;

public class TrainerActions extends PersonalPokemon{
	Creature personal;
	Creature enemy;
	//this is so i can use the above in this class
	public TrainerActions(Creature personal, Creature enemy) {
		//be able to get personal and enemy pokemon
		this.personal = personal;
		this.enemy = enemy;
	}
	public void capture(){
		//be able to attempt to capture the pokemon based on level and speed or something like that
		if(enemy.getHP()== 0) {
			addPokemon(enemy);
		}
		else if(enemy.getHP()<=1) {
			if(randomChance()<10) {
				addPokemon(enemy);
			}else {
				System.out.println("you have failed to capture");
			}
			}else if(enemy.getHP() <= 3) {
				if(randomChance()>5) {
					addPokemon(enemy);
				}else {
					System.out.println("you have failed to capture");
				}
		}else if(enemy.getHP() >= 4) {
			System.out.println("you have failed to capture");
		}
			
		}
	public int randomChance() {
		return (int) (Math.random()*10+1);
	}
	public void attacks() {
		
	}
	public void run() {
		if(personal.getSpeed() > enemy.getSpeed()) {
			
		}
	}
}
	