
import org.junit.jupiter.api.Test;
public class CreatureTest {

		@Test
		public void createCreature(){
			PersonalPokemon deck = new PersonalPokemon();
			Creature a = new Creature("a");
			Creature b = new Creature("b");
			Creature c = new Creature("c");
			Creature d = new Creature("d");
			Creature e = new Creature("e");
			Creature f = new Creature("f");
			//Creature g = new Creature("g");

			deck.addPokemon(a);
			deck.addPokemon(b);
			deck.addPokemon(c);
			deck.addPokemon(d);
			deck.addPokemon(e);
			deck.addPokemon(f);
			//deck.addPokemon(g);
			
		}
}
