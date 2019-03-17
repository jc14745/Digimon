
public class TrainerActions extends PersonalPokemon{
	Creature personalPokemon;
	Creature enemy;
	//this is so i can use the above in this class
	public TrainerActions(Creature personalPokemon, Creature enemy) {
		//be able to get personal and enemy pokemon
		this.personalPokemon = personalPokemon;
		this.enemy = enemy;
	}
	public void capture(){
		//be able to attempt to capture the pokemon based on level and speed or something like that
		if(Storage[1].getPokeBalls() != 0) {
		if(enemy.getHP()== 0) {
			addPokemon(enemy);
			Storage[1].removePokeballs();
		}
		else if(enemy.getHP()<=1) {
			if(randomChance()<10) {
				Storage[1].removePokeballs();
				addPokemon(enemy);
				
			}else {
				Storage[1].removePokeballs();
				System.out.println("you have failed to capture");
			}
			}else if(enemy.getHP() <= 3) {
				if(randomChance()>5) {
					Storage[1].removePokeballs();
					addPokemon(enemy);
				}else {
					Storage[1].removePokeballs();
					System.out.println("you have failed to capture");
				}
		}else if(enemy.getHP() >= 4) {
			Storage[1].removePokeballs();
			System.out.println("you have failed to capture");
		}
		}else {
			System.out.println("you have no pokeballs!!:p");
		}
			
		}
	public int randomChance() {
		return (int) (Math.random()*10+1);
	}
	}
	