package GameFunction;

public class EnemyList {
	public EnemyList(){
        createCreature();

    }
		public EnemyTree enemyDeck = new EnemyTree();
		
		EnemyTree Deck;
	public void createCreature() {
	
		
		//Creature(String name, int speed, int attack, int defense, int HP, int level)
		
		Creature Zubat = new Creature("Zubat", 3, 1, 1, 2, 1);//#041
		
		
		Creature Pidgey = new Creature("Pidgey", 3, 1, 2, 5, 2);//#016
	
		
		Creature Caterpie  = new Creature("Caterpie ", 3, 1, 2, 5, 2);//#010

		
		Creature Rattata = new Creature("Rattata", 4, 3, 1, 6, 3);//#019
	
		
		Creature Clefairy = new Creature("Clefairy", 2, 1, 2, 6, 3);//#035
		
		
		Creature Paras = new Creature("Paras", 2, 1, 3, 6, 3);//#046
		
		
		Creature Bellsprout = new Creature("Bellsprout", 1, 5, 8, 7 ,3);
		
		Zubat.setRight(Caterpie);
		Zubat.setLeft(Pidgey);
		Zubat.getLeft().setLeft(Rattata);
		Zubat.getLeft().setRight(Clefairy);
		Zubat.getRight().setLeft(Paras);
		Zubat.getRight().setRight(Bellsprout);
		
		
		enemyDeck.createRoot(Zubat);
		//enemyDeck.add(Zubat);
		
		
	}
	public void setCreature() {
		Deck = enemyDeck;
	}
	public EnemyTree getDeck() {
		return Deck;
	}
}
