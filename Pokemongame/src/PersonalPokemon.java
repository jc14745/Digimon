public class PersonalPokemon{
	int PokeOrder;
	int PokeLimits = 6;
	int PokeStorageNum;
	Creature[] pokeMon = new Creature[PokeLimits];
	Items[] Storage = new Items[2];
	Creature[] BillComputer = new Creature[PokeLimits*2];
	private int numberofItems;
	public void storePersonalPokemon(Creature Pokemon) {
		pokeMon[PokeOrder] = Pokemon;
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
				}
			}
			else {
				
			}
		}
	}//this will just add the pokemon
	public void addPokemon(Creature newPokemon) {
		if(PokeOrder != 6) {
			pokeMon[PokeOrder] = newPokemon;
		PokeOrder++;
		
		}
		else {
			System.out.println("You have too many pokemon!!");
			System.out.println("Your pokemone will be store here");
			storePoke(newPokemon);
		}
	}
	public void storePoke(Creature newPokemon) {
		if(PokeStorageNum > BillComputer.length) {
			DoubleSpace();
		}
		BillComputer[PokeStorageNum] = newPokemon;
		PokeStorageNum++;
	}//it needs a way to change pokemon
	public void changePokemonfromStorage(String NameCreature) {
		for(int NumofPoke = 0; NumofPoke < BillComputer.length-1;NumofPoke++) {
			if(NameCreature.equalsIgnoreCase(BillComputer[NumofPoke].name)) {
				if(PokeOrder >= 6) {
					System.out.println("you have too many pokemon");
				}else {
					pokeMon[PokeOrder] = BillComputer[NumofPoke];
				}
			}
		}
	}//this will increase the space for storing computers
	public void DoubleSpace() {
		Creature[] newTemp = new Creature[BillComputer.length*2];
		for(int PokeInBill = 0; PokeInBill < PokeStorageNum;PokeInBill++) {
			newTemp[PokeInBill] = BillComputer[PokeInBill];
		}
		this.BillComputer = newTemp;
	}// the items are going be for now 1 is healing potions and 2 is pokeballs
	public void StoreItems(int numberofItem) {
		Items pokeStuff = new Items();
		if(numberofItem == 1) {
			pokeStuff.addhealingitems();
			Storage[0] = pokeStuff;
		}
		else if(numberofItems==2) {
			pokeStuff.addPokeballs();
			Storage[1] = pokeStuff;
		}else {
			System.out.println("we don't have the item yet!?");
		}
	}
}