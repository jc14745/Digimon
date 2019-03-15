
import java.util.HashMap;
import java.util.Map;
public class MapDigimon {
	//* the Lv should look like Lv1A the A will represent the pokemon like
	//agumon will be A and be lv 1 and pikachu will be B and also lv 1
	//agumon = 11 and pikachu = 12
	Map<Integer, Creature> Digimon = new HashMap<Integer, Creature>();
	public void put(int lv, Creature C) {
		 Digimon.put(lv, C);
	}
	public void search(int lv) {
		Digimon.get(random(lv));
	}
	public int random(int lv) {
		int maxNumber = lv*10;
		int minNumber = maxNumber -9;
		int Random = (int) (Math.random()*maxNumber+ minNumber);
		return Random;
	}
}
