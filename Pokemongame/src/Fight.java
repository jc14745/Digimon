
public class Fight {
	EnemiesDigimon enemyDeck;
	PersonalPokemon personalDeck;
	Fight(EnemiesDigimon enemyDeck, PersonalPokemon personalDeck){
		this.enemyDeck = enemyDeck;
		this.personalDeck = personalDeck;
	}
	public Creature getEnemy(){
		return enemyDeck.getEnemy(enemyDeck.getRoot());
	}
	public Creature getPersonalPokemon(int i) {
		return personalDeck.getPokemon(i);
	}
	
	public void firstMove(int i){
		System.out.println(this.getEnemy().getName() + " " +this.getEnemy().getHP());
		System.out.println(this.getPersonalPokemon(i).getName() + " " +this.getPersonalPokemon(i).getHP());
		if(this.getPersonalPokemon(i).getHP() == 0) {
			lost();
		}
		else if(this.getEnemy().getHP() == 0) {
			win();
		}
		else if(this.getPersonalPokemon(i).getSpeed() > this.getEnemy().getSpeed()) {
			attack(this.getPersonalPokemon(i), this.getEnemy());
			System.out.println(this.getEnemy().getHP());
		}
		else{
			attack( this.getEnemy(),this.getPersonalPokemon(i));
			
			System.out.println(this.getPersonalPokemon(i).getName() + " " +this.getPersonalPokemon(i).getHP());
			
		}
		
		firstMove(i);
	}
	
	public void attack(Creature a, Creature b){
		if(b.getDefense() < a.getAttack()) {
			System.out.println("@");
		b.setHP(b.getHP()-a.attack);
		}
		else {
			b.setHP(b.getHP()- (a.attack/2)); 
			System.out.println("@");
			}
		}
	public void win() {
		System.out.println("you won");
		System.exit(0);
	}
	public void lost() {
		System.out.println("your pokemon died");
		System.exit(0);
	}
}

