package TestCreator;

import java.util.Scanner;

import GameFunction.EnemyList;
import GameFunction.Fight;
import GameFunction.Items;
import GameFunction.StartDeck;

public class TextedbasedPoke {

	public static void main(String[] args) {
		StartDeck deckP = new StartDeck();
		EnemyList deckE = new EnemyList();
		Items items = new Items();
		
		Scanner input = new Scanner(System.in);
		//this was on purpose ps
		System.out.println("Welcome Trainer Please yell me your Name");
		String Name = input.next();
		deckP.SetName(Name);
		System.out.println("Welome"+deckP.getName()+" to the wonderful world of Digimon");
		System.out.println(" Your First Pokemon will be Peekatchu!");
		System.out.println("Now its time to fight Lets GO YOU fithly Smite Player!!");
		deckE.createCreature();
		deckE.setCreature();
		Fight fight = new Fight(deckE.getDeck(), deckP.getDeck());
		System.out.println("Choose your pokemon from 0 to 5");
		for(int poke = 0; poke < deckP.newDeck.getNumberofPokemon();poke++) {
			System.out.println(poke + " " + deckP.getDeck().getPokemon(poke).getName());
		}
		int pokenumber = input.nextInt();
		System.out.println("Go "+fight.getPersonalPokemon(pokenumber).getName()+"!");
		System.out.println("Go "+deckE.getDeck().getRoot().getName()+"!");
		fight.firstMove();
		
		
	}

}
