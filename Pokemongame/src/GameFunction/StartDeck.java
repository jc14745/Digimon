package GameFunction;

public class StartDeck {
		
		PersonalPokemon newDeck = new PersonalPokemon();
		
		public void createDeck() {
				
			Creature Pikachu = new Creature("Pikachu", 3, 2, 2, 7, 1);
			newDeck.addPokemon(Pikachu);
			System.out.println("Hello new trainer! Here is your first pokemon!");
			
			System.out.println("You have obtained " + Pikachu.getName() );
		
		}
		
		
}
