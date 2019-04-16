package GameFunction;

import java.util.Scanner;

public class PersonalPokemon extends BillComputer
{
	int Money;
	int PokeOrder;
	int PokeLimits = 6;
	int PokeStorageNum;
	int pokenumber;
	boolean GameOver = true;
	
	Creature[] pokeMonStats = new Creature[PokeLimits*2];
	Creature[] pokeMon = new Creature[PokeLimits];
	Items[] Storage = new Items[2];
	//this is where the billcomputer storage for some reason it was acting like a data field instead of calling of another class so i 
	//just extended the billcomputer class so i can have access with all the classes
	
	Scanner input = new Scanner(System.in);
	public void storePersonalPokemon(Creature Pokemon) {
		pokeMon[PokeOrder] = Pokemon;
		pokeMonStats[PokeOrder] = Pokemon;
		PokeOrder++;
	}
	public Creature getPokemon(int i) {
		return pokeMon[i];
	}
	
	public void removesPokemon(String Pokemon) {
		for(int PokeName = 0; PokeName < pokeMon.length-1;PokeName++) {
			if(pokeMon[PokeName].getName().equalsIgnoreCase(Pokemon)) {
				PokeOrder--;
				pokeMon[PokeName] = null;
				movePokemonlist();
			}
			else {
				//this is just to make it go if anything happens
				System.out.println("removesPokemon error");
			}
		}
	}//this is to move the array down and fix it 
	public void movePokemonlist() {
			for(int NumofPoke= 0; NumofPoke < pokeMon.length-1;NumofPoke++) {
				if(pokeMon[NumofPoke] == null) {
					if(NumofPoke+1 < pokeMon.length) {
						pokeMon[NumofPoke] = pokeMon[NumofPoke+1];
					}
					else {
						//this one is to check if it reaches the end of the pokemon array so it doesnt break
						System.out.println("movePokemonlist error");
						
					}
				}
			}	
		}
	
	//this will just add the pokemon
	public void addPokemon(Creature newPokemon) {
		if(PokeOrder != 6) {
			pokeMon[PokeOrder] = newPokemon;
			pokeMonStats[PokeOrder] = newPokemon;
		PokeOrder++;
		
		}
		else {
			System.out.println("You have too many pokemon!");
			System.out.println("Your pokemon will be stored here.");
			storePoke(newPokemon);
		}
	}
	
	// the items are going be for now 1 is healing potions and 2 is pokeballs
	public void StoreItems(int numberofItem) {
		Items pokeStuff = new Items();
		if(numberofItem == 1) {
			pokeStuff.addhealingitems();
			Storage[0] = pokeStuff;
		}
		else if(numberofItem==2) {
			pokeStuff.addPokeballs();
			Storage[1] = pokeStuff;
		}else {
			System.out.println("We don't have the item yet.");
		}
	}
	public int getPokeball() {
		return Storage[1].getPokeBalls();
	}
	public int gethealing() {
		return Storage[0].getHealingPotions();
	}
	public int getNumberofPokemon() {
		return PokeOrder;
	}
	public void money() {
		Money =+100;
	}public int getMoney() {
		return Money;
	}
	public void pokecenter(Creature Ally) {
		for(int pokemon = 0; pokemon < pokeMonStats.length-1;pokemon++) {
			if(pokeMonStats[pokemon] != null && Ally.getName().equalsIgnoreCase(pokeMonStats[pokemon].getName())) {
				Ally.resetTmpHealth();
				}
		}
	}
	public void setGameOver() {
		GameOver = false;
	}public boolean getGameOver() {
		return GameOver;
	}
	public int  CheckingChosePoke(String A) {
		if(A.contains("0")||A.contains("1")||A.contains("2")||A.contains("3")||A.contains("4")||A.contains("5")) {
			pokenumber = Integer.parseInt(A);
			if(pokenumber < PokeOrder) {
					 return pokenumber;
			}else {
				System.out.println("Invalid pokemon slot.");
				A = input.nextLine();
				CheckingChosePoke(A);
			}
		
		}else {
			System.out.println("Invalid pokemon slot.");
			A = input.nextLine();
			CheckingChosePoke(A);
		}
		return pokenumber;
	}
}