
public class EnemyList {
	public void createCreature() {

		PersonalPokemon deck = new PersonalPokemon();
		Creature a = new Creature("a");
		a.setLevel(2);
		Creature b = new Creature("b");
		b.setLevel(3);
		Creature c = new Creature("c");
		c.setLevel(8);
		Creature d = new Creature("d");
		d.setLevel(1);
		Creature e = new Creature("e");
		e.setLevel(2);
		Creature f = new Creature("f");
		f.setLevel(6);

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
