package GameFunction;


public class Fight {
	
	EnemiesDigimon enemyDeck;
	PersonalPokemon personalDeck;
	Creature enemy, ally;
	Fight(EnemiesDigimon enemyDeck, PersonalPokemon personalDeck){
		this.enemyDeck = enemyDeck;
		this.personalDeck = personalDeck;
		this.enemy = getEnemy();
		this.ally = getPersonalPokemon();
	}
	public Creature getEnemy(){
		return enemyDeck.getEnemy(enemyDeck.getRoot());
	}
	public Creature getPersonalPokemon() {
		//wait for keystroke select pokemon
		return personalDeck.getPokemon(0);//for now its 0
	}
	
	public void firstMove(){
		System.out.println(this.enemy.getName() + " " +this.enemy.getHP());
		System.out.println(this.ally.getName() + " " + this.ally.getHP());
		
		TrainerActions trainerActionsDuringFight = new TrainerActions(this.ally, this.getEnemy());
		if(this.ally.getHP() == 0 || this.ally.getHP() < 0) {
			lost();
		}
		else if(this.getEnemy().getHP() < 0) {
			System.out.println("You have killed the enemy pokemon.");
				this.getEnemy().setTrue();
				win();
		}
		
		else if(this.ally.getSpeed() > this.getEnemy().getSpeed()) {
			
			trainerActionsDuringFight.capture();//key stroke choose action
			
			attack(this.ally, this.enemy);
			System.out.println(this.getEnemy().getHP());
			nextMove1();
			firstMove();
		}
		else{
			//automatic attack from attack list
			attack(this.enemy,this.ally);
			System.out.println(this.ally.getName() + " " + this.ally.getHP());
			nextMove2();
			firstMove();
			
		}
		
		
		
	}
	public void nextMove1(){
		//automatic attack from attack list
		attack(this.getEnemy(),this.ally);
	}
	
	public void nextMove2(){
		//keystrokes to choose action
		attack(this.ally, this.getEnemy());
	}
	
	public void attack(Creature a, Creature b){//creature a attacks creature b and takes b's hp away
		if(b.getDefense() < a.getAttack()) {
			
		b.setHP(b.getHP()-a.attack);
		}
		else {
			b.setHP(b.getHP()- (a.attack/2)); 
		
			}
		}
	public void win() {
		System.out.println("you won");
		
	}
	public void lost() {
		System.out.println("your pokemon died");
		
	}
}

