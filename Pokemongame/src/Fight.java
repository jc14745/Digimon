
public class Fight {
	EnemiesDigimon enemyDeck;
	PersonalPokemon personalDeck;
	Fight(EnemiesDigimon enemyDeck, PersonalPokemon personalDeck){
		this.enemyDeck = enemyDeck;
		this.personalDeck = personalDeck;
	}
	public void getEnemy(){
		
	}
	public Creature getPersonalPokemon(int i) {
		return personalDeck.getPokemon(i);
	}
	
	public void firstMove(int i){
		if(this.getPersonalPokemon(i).getSpeed() > this.getEnemy().getSpeed()) {
			
		}
	}
	
	attack(){
		
	}
}
