
import org.junit.jupiter.api.Test;
public class CreatureTest {

		@Test
		public void createCreature(){
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
			
			//deck.addPokemon(g);
			EnemiesDigimon enemyDeck = new EnemiesDigimon();
			enemyDeck.StoreEnemies(a);
			enemyDeck.StoreEnemies(b);
			enemyDeck.StoreEnemies(c);
			enemyDeck.StoreEnemies(d);
			enemyDeck.StoreEnemies(e);
			enemyDeck.StoreEnemies(f);
			
			for(int i=0; i< 5; i++) {
				System.out.println(enemyDeck.Enemies[i].getName());
			}
			
		}
}
