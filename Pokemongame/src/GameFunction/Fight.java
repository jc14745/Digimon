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
		System.out.println(this.enemy.getName() + " " +this.enemy.getHP());
		System.out.println(this.ally.getName() + " " + this.ally.getHP());
		
		
		if(this.ally.getHP() == 0 || this.ally.getHP() < 0) {
			lost();
		}
		else if(this.getEnemy().getHP() < 0) {
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
	public void setChose(int Chose) {
		this.Chose = Chose;
	}
	public void CaptureDialoge() {
		System.out.println("Would you like to Capture this pokemon?");
		System.out.println("Hit 1 for Yes and Hit 0 for No");
		int Chose = input.nextInt();
		setChose(Chose);
	}
	
}

