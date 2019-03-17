package GameFunction;


public class Fight {
	int i = 0;//some keystroke
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
		
		TrainerActions trainerActionsDuringFight = new TrainerActions(this.getPersonalPokemon(i), this.getEnemy());
		if(this.getPersonalPokemon(i).getHP() == 0 || this.getPersonalPokemon(i).getHP() < 0) {
			lost();
		}
		else if(this.getEnemy().getHP() == 0 || this.getEnemy().getHP() < 0) {
			if(this.getEnemy().getHP() == 0) {
				//key strokes choose action
				
				trainerActionsDuringFight.capture();
				win();//give oprotunity to capture
				
			}
			else {
				System.out.println("You have killed the enemy pokemon.");
				this.getEnemy().setTrue();
				win();
			}
		}
		
		else if(this.getPersonalPokemon(i).getSpeed() > this.getEnemy().getSpeed()) {
			
			//key stroke choose action
			
			attack(this.getPersonalPokemon(i), this.getEnemy());
			System.out.println(this.getEnemy().getHP());
			nextMove1(i);
		}
		else{
			//automatic attack from attack list
			attack(this.getEnemy(),this.getPersonalPokemon(i));
			System.out.println(this.getPersonalPokemon(i).getName() + " " +this.getPersonalPokemon(i).getHP());
			nextMove2(i);
			
		}
		
		firstMove(i);
		
	}
	public void nextMove1(int i){
		//automatic attack from attack list
		attack(this.getEnemy(),this.getPersonalPokemon(i));
	}
	
	public void nextMove2(int i){
		//keystrokes to choose action
		attack(this.getPersonalPokemon(i), this.getEnemy());
	}
	
	public void attack(Creature a, Creature b){
		if(b.getDefense() < a.getAttack()) {
			
		b.setHP(b.getHP()-a.attack);
		}
		else {
			b.setHP(b.getHP()- (a.attack/2)); 
		
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

