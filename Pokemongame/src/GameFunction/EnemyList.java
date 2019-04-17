package GameFunction;
/*once the enemy list is intantiated the class auto generates the enemy binary tree 
 * putting the enemy pokemon and their preset stats in a binary tree
 */
public class EnemyList {
	public EnemyList(){
        createCreature();

    }
		public EnemyTree enemyDeck = new EnemyTree();
		
		EnemyTree Deck;
	public void createCreature() {
	
		
		//Creature(String name, int speed, int attack, int defense, int HP, int level)
		
		Creature Zubat = new Creature("Zubat", 3, 1, 1, 2, 1);//#041
		
		
		Creature Pidgey = new Creature("Pidgey", 3, 2, 2, 5, 2);//#016
	
		
		Creature Caterpie  = new Creature("Caterpie", 3, 2, 2, 5, 2);//#010

		
		Creature Rattata = new Creature("Rattata", 4, 3, 1, 8, 3);//#019
	
		
		Creature Clefairy = new Creature("Clefairy", 2, 4, 2, 8, 3);//#035
		
		
		Creature Paras = new Creature("Paras", 2, 3, 3, 10, 3);//#046
		
		
		Creature Bellsprout = new Creature("Bellsprout", 1, 6, 8, 9 ,3);
		
		Zubat.setRight(Caterpie);
		Zubat.setLeft(Pidgey);
		Zubat.getLeft().setLeft(Rattata);
		Zubat.getLeft().setRight(Clefairy);
		Zubat.getRight().setLeft(Paras);
		Zubat.getRight().setRight(Bellsprout);
		
		
		enemyDeck.createRoot(Zubat);
		
		/*					  zubat							level 1
		 * 		          /             \
		 * 			pidgey	            caterpie			level 2
		 * 			/    \             /        \
		 * 		rattata  clefariy    paras    bellsprout	level 3
		 */
		
	}
	public void setCreature() {
		Deck = enemyDeck;
	}
	public EnemyTree getDeck() {
		return Deck;
	}
}
