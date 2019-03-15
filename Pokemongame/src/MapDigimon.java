
import java.util.HashMap;
import java.util.Map;
public class MapDigimon {
	//* the Lv should look like Lv1A the A will represent the pokemon like
	//agumon will be A and be lv 1 and pikachu will be B and also lv 1
	//agumon = 11 and pikachu = 12
	Map<Integer, Creature> Digimon = new HashMap<Integer, Creature>();
	int MaxNumberOfE;
	public void put( Creature C) {
		int lv = 1;
		int lv2 = 11;
		int lv3 = 21;
		int lv4 = 31;
		int lv5 = 41;
		int lv6 = 51;
		int lv7 = 61;
		int lv8 = 71;
		int lv9 = 81;
		int lv10 = 91;
		if(C.getLevel()<10) {
			Digimon.put(lv,C);
			lv++;
		}
		else if(C.getLevel()<20) {
			Digimon.put(lv2, C);
			lv2++;
		}
		else if(C.getLevel()<30) {
			Digimon.put(lv3, C);
			lv3++;
		}
		else if(C.getLevel()<40) {
			Digimon.put(lv4, C);
			lv4++;
		}
		else if(C.getLevel()<50) {
			Digimon.put(lv5, C);
			lv5++;
		}
		else if(C.getLevel()<60) {
			Digimon.put(lv6, C);
			lv6++;
		}
		else if(C.getLevel()<70) {
			Digimon.put(lv7, C);
			lv7++;
		}
		else if(C.getLevel()<80) {
			Digimon.put(lv8, C);
			lv8++;
		}
		else if(C.getLevel()<90) {
			Digimon.put(lv9, C);
			lv9++;
		}
		else if(C.getLevel()<100) {
			Digimon.put(lv10, C);
			lv10++;
		}
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
