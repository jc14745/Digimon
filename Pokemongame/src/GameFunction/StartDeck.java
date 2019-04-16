package GameFunction;
/*The start deck instantiates the creature class and allows 
 * the player to obtain a "pikachu" as well obtain the player's name.
 * 
 */
public class StartDeck {
	String Name;
	boolean GameOver = true;
	 public StartDeck(){
        createDeck();
        
    }
		public PersonalPokemon newDeck = new PersonalPokemon();
		public void createDeck() {
			//Creature(String name, int speed, int attack, int defense, int HP, int level)
			Creature Pikachu = new Creature("Pikachu", 3, 2, 2, 4, 1);
			newDeck.addPokemon(Pikachu);
			newDeck.StoreItems(2);
			System.out.println("Hello new trainer! Here is your first pokemon!");
			System.out.println("You have obtained " + Pikachu.getName() + ".");
		}
		public void SetName(String Name) {
			this.Name = Name;
		}
		public String getName() {
			return Name;
		}
		public PersonalPokemon getDeck() {
			return newDeck;
		}public void setGameOver() {
			GameOver = false;
		}public boolean getGameOver() {
			return GameOver;
		}
		
		
}