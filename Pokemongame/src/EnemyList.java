
public class EnemyList {
	public void createCreature() {
		//Creature(String name, int speed, int attack, int defense, int HP, int level)
		
		Creature Zubat = new Creature("Zubat", 3, 2, 1, 5, 1);//#041
		
		
		Creature Pidgey = new Creature("Pidgey", 3, 2, 2, 10, 2);//#016
	
		
		Creature Caterpie  = new Creature("Caterpie ", 3, 2, 2, 10, 2);//#010

		
		Creature Rattata = new Creature("Rattata", 4, 3, 2, 10, 3);//#019
	
		
		Creature d = new Creature("d");
		d.setLevel(1);
		Creature e = new Creature("e");
		e.setLevel(2);
		Creature f = new Creature("f");
		f.setLevel(6);

		
		Pidgey.setRight(c);
		Pidgey.setLeft(Caterpie);
		Pidgey.getLeft().setLeft(d);
		Pidgey.getLeft().setRight(e);
		Pidgey.getRight().setLeft(f);
		
		EnemiesDigimon enemyDeck = new EnemiesDigimon();
		
		enemyDeck.createRoot(a);
		enemyDeck.add(a);
		
		a.setLevel(2);
		b.setLevel(3);
		c.setLevel(8);
		d.setLevel(11);
		e.setLevel(21);
		f.setLevel(61);

		
		deck.addPokemon(a);
		deck.addPokemon(b);
		deck.addPokemon(c);
		deck.addPokemon(d);
		deck.addPokemon(e);
		deck.addPokemon(f);
		
		a.setRight(c);
		a.setLeft(b);
		a.getLeft().setLeft(d);
		a.getLeft().setRight(e);
		a.getRight().setLeft(f);
		
		enemyDeck.createRoot(a);
		enemyDeck.add(a);
		
	}
}
