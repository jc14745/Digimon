
import org.junit.jupiter.api.Test;
public class CreatureTest {

		@Test
		public void createCreature(){

<<<<<<< HEAD
=======
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
			//Creature g = new Creature("g");

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
			
			//deck.addPokemon(g);
			EnemiesDigimon enemyDeck = new EnemiesDigimon();
			/*enemyDeck.StoreEnemies(a);
			enemyDeck.StoreEnemies(b);
			enemyDeck.StoreEnemies(c);
			enemyDeck.StoreEnemies(d);
			enemyDeck.StoreEnemies(e);
			enemyDeck.StoreEnemies(f);
			
			for(int i=0; i< 5; i++) {
				System.out.println(enemyDeck.Enemies[i].getName());
			}
			*/
			enemyDeck.createRoot(a);
			enemyDeck.add(a);

			MapDigimon Digi = new MapDigimon();
>>>>>>> refs/remotes/origin/master
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
			/*enemyDeck.StoreEnemies(a);
			enemyDeck.StoreEnemies(b);
			enemyDeck.StoreEnemies(c);
			enemyDeck.StoreEnemies(d);
			enemyDeck.StoreEnemies(e);
			enemyDeck.StoreEnemies(f);
			
			for(int i=0; i< 5; i++) {
				System.out.println(enemyDeck.Enemies[i].getName());
			}
			*/
			enemyDeck.createRoot(a);
			enemyDeck.add(a);

			MapDigimon Digi = new MapDigimon();
			
			
			a.setLevel(2);
			b.setLevel(3);
			c.setLevel(8);
			d.setLevel(11);
			e.setLevel(21);
			f.setLevel(61);
		
			
			Digi.put(a);
			Digi.put(b);
			Digi.put(c);
			Digi.put(d);
			Digi.put(e);
			Digi.put(f);

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
			//deck.addPokemon(g);
			/*enemyDeck.StoreEnemies(a);
			enemyDeck.StoreEnemies(b);
			enemyDeck.StoreEnemies(c);
			enemyDeck.StoreEnemies(d);
			enemyDeck.StoreEnemies(e);
			enemyDeck.StoreEnemies(f);
			
			for(int i=0; i< 5; i++) {
				System.out.println(enemyDeck.Enemies[i].getName());
			}
			*/
			enemyDeck.createRoot(a);
			enemyDeck.add(a);
<<<<<<< HEAD
			
=======
>>>>>>> refs/remotes/origin/master

		}
}
