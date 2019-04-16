package GameFunction;

import java.util.Scanner;
/*This is the starting point in the program which instantiates the EnemyTree, TrainerAction, 
 * MovementTrainer, Creature, and PersonalPokemon classes.
 * 
 * 
 */
public class TextedbasedPoke {
	public static void main(String[] args) {
	
		StartDeck deckP = new StartDeck();
		EnemyList deckE = new EnemyList();
		MovementTrainer move = new MovementTrainer();
		Items items = new Items();
		//takes in the name through the console
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome trainer please tell me your name.");
		String Name = input.nextLine();
		deckP.SetName(Name);
		
		System.out.println("Welome "+deckP.getName()+" to the wonderful world of Pokemon");
		System.out.println("Now it's time to fight! Go and capture some Pokemon!");
		deckE.createCreature();
		deckE.setCreature();
		Fight fight = new Fight(deckE.getDeck(), deckP.getDeck());
		System.out.println("Choose your pokemon from 0 to 5");
		
		for(int poke = 0; poke < deckP.newDeck.getNumberofPokemon();poke++) {
			System.out.println(poke + " " + deckP.getDeck().getPokemon(poke).getName());
		}
		
		String Spokenumber = input.nextLine();
		fight.firstMove();
		deckP.getDeck().money();
		int money= deckP.getDeck().getMoney();
		System.out.println("You have won the first battle here is your money "+money);
		
		while(true) {
			
			//move.setEnemy(deckE.getDeck().getEnemy(deckE.getDeck().getRoot()));
			System.out.println("Where would you like to go?");
			System.out.println("Place input(only keys W A S D accepted)");
			String movement = input.nextLine();
			move.Move(movement, fight);
			System.out.println("You have moved "+move.getDirections());
			
		}
	}

}
