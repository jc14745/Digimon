package GameFunction;

public class TrainerActions {
	PersonalPokemon personalPokemon;
	Creature enemy;

	// this is so i can use the above in this class
	public TrainerActions(PersonalPokemon personalPokemon, Creature enemy) {
		// be able to get personal and enemy pokemon
		this.personalPokemon = personalPokemon;
		this.enemy = enemy;
	}// healing

	public void healing(int pokemon) {
		if (personalPokemon.gethealing() > 0) {
			int healing = 0;
			healing = personalPokemon.pokeMon[pokemon].getHP() + 4;
			personalPokemon.pokeMon[pokemon].setHP(healing);
			personalPokemon.Storage[0].removeHealing();
		} else {
			System.out.println("No healing Available");
		}

	}

	public void capture(int Chose) {

		if (Chose == 1) {
			if (personalPokemon.getPokeball() != 0) {// gets pokeball
				if (enemy.getTmpHealth() == 0) {
					caughtPokemon();
				} else if (enemy.getTmpHealth() <= 1) {
					if (randomChance() < 10) {
						caughtPokemon();

					} else {
						uncaughtPokemon();
					}
				} else if (enemy.getTmpHealth() <= 3) {
					if (randomChance() > 5) {
						caughtPokemon();
					} else {
						uncaughtPokemon();
					}
				} else if (enemy.getTmpHealth() >= 4) {
					uncaughtPokemon();
				}
			} else {
				System.out.println("you have no pokeballs!!:p");
			}
		} else {
			System.out.println("let fights");
		}
	}

	public int randomChance() {
		return (int) (Math.random() * 10 + 1);
	}

	public void caughtPokemon() {//will happen if the pokemon is catchable
		personalPokemon.Storage[1].removePokeballs();
		personalPokemon.addPokemon(enemy);
		enemy.setCatchTrue();
		enemy.setTrue();
		System.out.println("You have caught " + enemy.getName());

	}

	public void uncaughtPokemon() {//will run if the pokemon ran away
		personalPokemon.Storage[1].removePokeballs();
		System.out.println("you have failed to capture");
	}
}
