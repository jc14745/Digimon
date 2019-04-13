package GameFunction;

import java.util.Scanner;

public class Fight {

	EnemyTree enemyDeck;
	PersonalPokemon personalDeck;
	Creature enemy, ally;
	int Choose, pokemon, lives;
	int numberPoke = 0;
	String Schoose, Slives, movement;
	boolean fighton = true;
	MovementTrainer MoveT = new MovementTrainer();
	Scanner input = new Scanner(System.in);

	public Fight(EnemyTree enemyDeck, PersonalPokemon personalDeck){
		this.enemyDeck = enemyDeck;
		this.personalDeck = personalDeck;
		this.enemy = getEnemy();
		this.ally = getPersonalPokemon(pokemon);
	}
	public Creature getEnemy(){

		return enemyDeck.getEnemy(enemyDeck.getRoot());
	}
	public Creature getPersonalPokemon(int pokemon) {
		
		this.pokemon = pokemon;
		return personalDeck.getPokemon(pokemon);
	}

	public void firstMove(){
		if(enemy.getUsed()==false) {
			System.out.println("\nEnemy Pokemon:"+ this.enemy.getName() + "   Health:" +this.enemy.getTmpHealth());
			System.out.println("Your Pokemon:" +this.ally.getName() + "  Health:" + this.ally.getTmpHealth() + "\n");
			if(this.ally.getTmpHealth() == 0 || this.ally.getTmpHealth() < 0) {
				lost();
			}
			else if(this.enemy.getTmpHealth()< 0) {
				System.out.println("You have killed the enemy pokemon.");
				win();
			}

			else if(this.ally.getSpeed() > this.enemy.getSpeed()) {
				
				TrainerActions trainerActionsDuringFight = new TrainerActions(personalDeck, this.enemy, this.ally);
				if(personalDeck.getPokeball()!=0) {

					if(trainerActionsDuringFight.capture(Choose) == true) win();

				}else if(personalDeck.getPokeball()==0) {
					System.out.println("Oh no you out of pokeballs!");
				}
				if(this.enemy.getUsed() == false) {
					CaptureDialoge();
					attack(this.ally, this.enemy);
					nextMove(this.enemy,this.ally);
					firstMove();
				}
				else {
					
					enemyDeck.resetNull(enemyDeck.getRoot());
					enemyDeck.getEnemy(enemyDeck.getRoot());
					firstMove();
				}	
			}
			else{
				
				if(this.enemy.getUsed() == false) {
					attack(this.enemy, this.ally);
					CaptureDialoge();
					nextMove(this.ally, this.enemy);
					firstMove();
				}
			}
		}
		else {
			
			enemyDeck.resetNull(enemyDeck.getRoot());
			enemy = enemyDeck.getEnemy(enemyDeck.getRoot());
			firstMove();

		}

	}


	public void nextMove(Creature a, Creature b){
		TrainerActions trainerActionsDuringFight = new TrainerActions(personalDeck, this.enemy, this.ally);
		if(personalDeck.getPokeball()!=0) {
			if(trainerActionsDuringFight.capture(Choose) == true) win();
		}
		else if(personalDeck.getPokeball()==0) {
			System.out.println("Oh no you are out of pokeballs!");
		}
		attack(a, b);
		//this is where it stop after capture

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
		this.ally.incrementStats();
		this.ally.resetTmpHealth();


	}
	public void lost() {
		numberPoke = 0;
		System.out.println("Your pokemon died.");
		if(personalDeck.PokeOrder==1) {
			System.out.println("Would you like to heal your pokemon?");
			System.out.println("Hit 1 for yes and hit 0 for no.");
			Slives = input.nextLine();
			checklive(Slives);
			//this will go thought the pokemon to check if there dead or not
		}
		else if(personalDeck.PokeOrder > 1){

			for(int pokemon = 0; pokemon < personalDeck.pokeMon.length-1;pokemon++) {
				if(personalDeck.pokeMon[pokemon] == null) {
					System.out.println("You have no more pokemon.");
					fighton=false;
					break;
				}else if(numberPoke == 6){
					System.out.println("All your pokemon are dead.");
					fighton=false;
					break;

				}else if(personalDeck.pokeMon[pokemon].getTmpHealth() <= 0){
					numberPoke++;
				}else if(personalDeck.pokeMon[pokemon] != null) {
					this.ally = personalDeck.pokeMon[pokemon];
					break;
				}
				else {
					System.out.println("Something went very wrong.");
				}
			}
			if(fighton) {
				firstMove();
			}
			else {
				System.out.println("Would you like to heal your pokemon?");
				System.out.println("Hit 1 for yes and hit 0 for no");

				Slives= input.nextLine();

				if(checkliveall(Slives)==1) {
					healingPokeCenter();
				}
				else if(checkliveall(Slives)==0){
					personalDeck.setGameOver();
					System.out.println("Game Over");
					System.exit(0);
				}
			}
		}	
	}
	public void setChoose(int Choose) {
		this.Choose = Choose;
	}
	public void CaptureDialoge() {
		System.out.println("Would you like to Capture this pokemon?");
		System.out.println("Hit 1 for Yes and Hit 0 for no.");

		Schoose = input.nextLine();
		if(Schoose.equalsIgnoreCase("1") || Schoose.equalsIgnoreCase("0")) {
			Choose = Integer.parseInt(Schoose);
			setChoose(Choose);

		}else {
			System.out.println("Invalid anwer please try again.");
			CaptureDialoge();
		}
	}
	public void healingPokeCenter(){
		for(int pokeheal = numberPoke-1; pokeheal >= 0;pokeheal--) {
			personalDeck.pokeMon[pokeheal].resetTmpHealth();
		}
		numberPoke = 0;
		System.out.println("All your pokemon are healed!");
		this.ally = personalDeck.getPokemon(0);
	}

	public void lives(int lives) {
		if(lives==1) {
			personalDeck.pokeMon[0].resetTmpHealth();;
			System.out.println("Your pokemon is healed.");
		}else if(lives==0){
			personalDeck.setGameOver();
			System.out.println("Game Over");
			System.exit(0);
		}else {
			System.out.println("Invalid number.");
			System.out.println("Hit 1 for Yes and Hit 0 for No");
			Slives = input.nextLine();
			checklive(Slives);
		}

	}//this also check but for another methods
	public void checklive(String B) {
		lives = Integer.parseInt(B);
		if(B.equalsIgnoreCase("1") || B.equalsIgnoreCase("0")) {
			if(lives == 0 || lives == 1) {
				lives = Integer.parseInt(Slives);
				lives(lives);
			}else {
				check(B);
			}	
		}
		// this is to check if the user input a wrong answer
	}

	public int checkliveall(String B) {
		lives = Integer.parseInt(B);
		if(B.equalsIgnoreCase("1") || B.equalsIgnoreCase("0")) {
			if(lives == 0 || lives == 1) {
				lives = Integer.parseInt(Slives);
				return lives;
			}else {
				check(B);
			}
		}
		return lives;
	}

	public void check(String B) {
		if(B.length() >1) {
			System.out.println("Invalid anwer please try again.");
			B = input.nextLine();
			checkliveall(B);
		}else if(lives > 1) {
			System.out.println("Invalid anwer please try again.");
			B = input.nextLine();
			checkliveall(B);
		}
	}
}