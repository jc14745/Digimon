package GameFunction;


public class Items {
	int powerRestortions;
	int pokeBalls = 100;
	int Healingpotions;
	
	public Items(){
		
	}
	public void addhealingitems() {
		Healingpotions++;
	}
	public void addPokeballs() {
		pokeBalls++;
	}
	public void removePokeballs() {
		if(pokeBalls == 0) {
			System.out.println("you have no pokeballs");
		}else {
			pokeBalls--;
		}
	}
	public int getPokeBalls() {
		return pokeBalls;
	}
	public int getHealingPotions() {
		return Healingpotions;
		
	}
	public void removeHealing() {
		if(Healingpotions == 0) {
			System.out.println("you have no healing");
		}else {
			Healingpotions--;
		}
	}
}
