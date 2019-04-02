package GameFunction;

import java.util.Scanner;

public class TextedbasedPoke {
	public static void main(String[] args) {
		StartDeck deckP = new StartDeck();
		EnemyList deckE = new EnemyList();
		MovementTrainer move = new MovementTrainer();
		Items items = new Items();
		Scanner input = new Scanner(System.in);
		//this was on purpose ps
		System.out.println("Welcome Trainer Please tell me your Name");
		String Name = input.nextLine();
		//add a check method to add more than a word
		deckP.SetName(Name);
		System.out.println("Welome "+deckP.getName()+" to the wonderful world of Pokemon");
	
		System.out.println("Now its time to fight! Go and capture some Pokemon!");
		deckE.createCreature();
		deckE.setCreature();
		Fight fight = new Fight(deckE.getDeck(), deckP.getDeck());
		System.out.println("Choose your pokemon from 0 to 5");
		//add a check method for checking what they type
		for(int poke = 0; poke < deckP.newDeck.getNumberofPokemon();poke++) {
			System.out.println(poke + " " + deckP.getDeck().getPokemon(poke).getName());
		}
		String Spokenumber = input.nextLine();
		System.out.println("Go "+fight.getPersonalPokemon(deckP.getDeck().CheckingChosePoke(Spokenumber)).getName()+"!");
		System.out.println("Go "+deckE.getDeck().getRoot().getName()+"!");
		fight.firstMove();
		deckP.getDeck().money();
		int money= deckP.getDeck().getMoney();
		System.out.println("you have won the first battle here your money"+" "+money);
		while(true) {
			
			//move.setEnemy(deckE.getDeck().getEnemy(deckE.getDeck().getRoot()));
			System.out.println("where would you like to go?");
			System.out.println("Place input only W A S D");
			String movement = input.nextLine();
			move.Move(movement, fight);
			System.out.println(" you have moved "+move.getDirections());
			
		}
	}

}
