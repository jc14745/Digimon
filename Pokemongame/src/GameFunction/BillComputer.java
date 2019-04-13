package GameFunction;

public class BillComputer {
	int PokeLimits;
	static int PokeStorageNum;
	Creature[] BillComputer = new Creature[PokeLimits*2];
	
	public void storePoke(Creature newPokemon) {
		if(PokeStorageNum > BillComputer.length) {
			DoubleSpace(PokeStorageNum);
		}
		BillComputer[PokeStorageNum] = newPokemon;
		PokeStorageNum++;
	}
	//if the computer's limits have been reached, this expands the size of the computer
		public void DoubleSpace(int PokeStorageNum) {
			Creature[] newTemp = new Creature[BillComputer.length*2];
			for(int PokeInBill = 0; PokeInBill < PokeStorageNum;PokeInBill++) {
				newTemp[PokeInBill] = BillComputer[PokeInBill];
			}
			this.BillComputer = newTemp;
		}
		
	//allows the player to change out pokemon from storage to their current deck
		public void changePokemonfromStorage(String NameCreatureOut, String CreatureIn, Creature[] pokeMon, Creature[] pokeMonStats) {
			int In = 0;
			for(int pokein=0; pokein < pokeMon.length-1;pokein++) {
				if(CreatureIn.equalsIgnoreCase(pokeMon[pokein].getName())) {
					In = pokein;
				}
			}
			for(int NumofPoke = 0; NumofPoke < BillComputer.length-1;NumofPoke++) {
				if(NameCreatureOut.equalsIgnoreCase(BillComputer[NumofPoke].name)) {
						Creature temp = pokeMon[In];
						Creature temp2 = BillComputer[NumofPoke];
						pokeMon[In] = temp2;
						BillComputer[NumofPoke] = temp;
						pokeMonStats[In] =temp2;
						pokeMonStats[NumofPoke] = temp;
				}
			}
		}
}
