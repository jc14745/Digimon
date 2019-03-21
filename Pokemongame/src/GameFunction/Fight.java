package GameFunction;

import java.util.Scanner;

import Graphics.DelayedUpdateAdapter;

public class Fight {
	public DelayedUpdateAdapter dua;
	EnemiesDigimon enemyDeck;
	PersonalPokemon personalDeck;
	Creature enemy, ally;
	int Chose;	
	int digimon;
	int lives;
	int numberPoke = 1;
	boolean fighton = true;
	Scanner input = new Scanner(System.in);
	
	public Fight(EnemiesDigimon enemyDeck, PersonalPokemon personalDeck){
		this.enemyDeck = enemyDeck;
		this.personalDeck = personalDeck;
		this.enemy = getEnemy();
		this.ally = getPersonalPokemon(digimon);
	
	}
	public Creature getEnemy(){
		
		return enemyDeck.getEnemy(enemyDeck.getRoot());
		
		
	}
	public Creature getPersonalPokemon(int digimon) {
		//wait for keystroke select pokemon
		//add scanner class
		this.digimon = digimon;
		return personalDeck.getPokemon(digimon);//for now its 0
	}
	
	public void firstMove(){
		if(enemy.getUsed()==false) {
		System.out.println(this.enemy.getName() + " " +this.enemy.getTmpHealth());
		System.out.println(this.ally.getName() + " " + this.ally.getTmpHealth());
		
		
		if(this.ally.getTmpHealth() == 0 || this.ally.getTmpHealth() < 0) {
			lost();
		}
		else if(this.getEnemy().getTmpHealth()< 0) {
			System.out.println("You have killed the enemy pokemon.");
				this.getEnemy().setTrue();
				win();
		}
		
		else if(this.ally.getSpeed() > this.getEnemy().getSpeed()) {
			//there are two method at the bottom
			TrainerActions trainerActionsDuringFight = new TrainerActions(personalDeck, this.getEnemy());
			if(personalDeck.getPokeball()!=0) {
			CaptureDialoge();
			trainerActionsDuringFight.capture(Chose);
			}else if(personalDeck.getPokeball()==0) {
				System.out.println("oh no you outta pokeballs! #feelsBadMan");
			}
			if(this.enemy.catchs == false) {
			//key stroke choose action
			attack(this.ally, this.enemy);
			System.out.println(this.getEnemy().getHP());
			nextMove1();
			firstMove();
			}
			else {
				this.enemy = getEnemy();
				firstMove();
			}
			
		}
		else{
			//automatic attack from attack list
			if(this.enemy.catchs == false) {
			attack(this.enemy,this.ally);
			System.out.println(this.ally.getName() + " " + this.ally.getHP());
			nextMove2();
			firstMove();
			}
		}
		}else {
			
		}
	}
	public void nextMove1(){
		//automatic attack from attack list
		if(this.enemy.catchs == false) {
		attack(this.getEnemy(),this.ally);
		}
	}
	
	public void nextMove2(){
		//keystrokes to choose action
		TrainerActions trainerActionsDuringFight = new TrainerActions(personalDeck, this.getEnemy());
		if(personalDeck.getPokeball()!=0) {
		CaptureDialoge();
		trainerActionsDuringFight.capture(Chose);
		}
		else if(personalDeck.getPokeball()==0) {
			System.out.println("oh no you outta pokeballs! #feelsBadMan");
		}
		if(this.enemy.catchs == false) {
		attack(this.ally, this.getEnemy());
		}
	}
	
	public void attack(Creature a, Creature b){//creature a attacks creature b and takes b's hp away
		if(b.getDefense() < a.getAttack()) {
			
		b.setTmpHealth(b.getTmpHealth()-a.attack);
		}
		else {
			b.setTmpHealth(b.getTmpHealth()- (a.attack/2)); 
		
			}
		}
	public void win() {
		System.out.println("you won");
		enemy.setTrue();
		enemy = enemyDeck.getEnemy(enemy);
		personalDeck.money();
		
	}
	public void lost() {
		System.out.println("your pokemon died");
		if(personalDeck.PokeOrder==numberPoke) {
			System.out.println("would you like to heal your pokemon?>_< plz say yess "+"Your "+ally.getName()+" needs you<3");
			System.out.println("hit 1 for yes and hit 0 for no");
			lives= input.nextInt();
			lives(lives);
		}else if(personalDeck.PokeOrder > 1){
			for(int pokemon = 0; pokemon < personalDeck.pokeMon.length-1;pokemon++) {
				if(personalDeck.pokeMon[pokemon].getTmpHealth() == 0) {
					numberPoke++;
				}else if(personalDeck.pokeMon[pokemon] == null){
					System.out.println("you have no more pokemon");
					fighton=false;
					break;
				}else if(numberPoke == 6){
					System.out.println("all your pokemon are dead");
					fighton=false;
					break;
				}else {
					break;
				}
			}
			if(fighton) {
			ally = personalDeck.pokeMon[numberPoke];
			firstMove();
			}
		}else {
			System.out.println("would you like to heal your pokemons?>_< plz say yess ");
			System.out.println("hit 1 for yes and hit 0 for no");
			lives= input.nextInt();
			if(lives==1) {
				healingPokeCenter();
			}else if(lives==0){
				personalDeck.setGameOver();
				System.out.println("Game Over");
			}
		}
		
	}
	public void setChose(int Chose) {
		this.Chose = Chose;
	}
	public void CaptureDialoge() {
		System.out.println("Would you like to Capture this pokemon?");
		System.out.println("Hit 1 for Yes and Hit 0 for No");
		int Chose = input.nextInt();
		if(Chose == 0 || Chose == 1) {
		setChose(Chose);
		}
		else {
			System.out.println("invalid anwer please try again");
			CaptureDialoge();
		}
		
	}
	public void healingPokeCenter(){
		for(int pokeheal = numberPoke; pokeheal >= 0;pokeheal--) {
			personalDeck.pokeMon[pokeheal].resetTmpHealth();
			//personalDeck.pokeMon[pokeheal].setHP(personalDeck.pokeMonStats[pokeheal].getHP());
		}
		numberPoke = 1;
		System.out.println("all your pokemon are healed!");
	}public void lives(int lives) {
		if(lives==1) {
			personalDeck.pokeMon[0].resetTmpHealth();;
			System.out.println("your pokemon is healed");
		}else if(lives==0){
			personalDeck.setGameOver();
			System.out.println("Game Over");
		}else {
			System.out.println("incorrect numebr put in Try again your pokemon need you?");
			System.out.println("Hit 1 for Yes and Hit 0 for No");
			lives = input.nextInt();
			lives(lives);
		}
	}
	
}