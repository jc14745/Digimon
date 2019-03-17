
public class EnemyList {
		EnemiesDigimon enemyDeck = new EnemiesDigimon();
	public void createCreature() {
	
		
		//Creature(String name, int speed, int attack, int defense, int HP, int level)
		
		Creature Zubat = new Creature("Zubat", 3, 2, 1, 5, 1);//#041
		
		
		Creature Pidgey = new Creature("Pidgey", 3, 2, 2, 10, 2);//#016
	
		
		Creature Caterpie  = new Creature("Caterpie ", 3, 2, 2, 10, 2);//#010

		
		Creature Rattata = new Creature("Rattata", 4, 3, 2, 12, 3);//#019
	
		
		Creature Clefairy = new Creature("Clefairy", 2, 2, 2, 12, 3);//#035
		
		
		Creature Paras = new Creature("Paras", 2, 4, 3, 12, 3);//#046
		
		
		//Creature Bellsprout = new Creature("Bellsprout", );
		
		Zubat.setRight(Caterpie);
		Zubat.setLeft(Pidgey);
		Zubat.getLeft().setLeft(Rattata);
		Zubat.getLeft().setRight(Clefairy);
		Zubat.getRight().setLeft(Paras);
		
		
		enemyDeck.createRoot(Zubat);
		enemyDeck.add(Zubat);
		
		
	}
}
