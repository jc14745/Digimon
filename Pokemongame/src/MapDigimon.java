
import java.util.HashMap;
import java.util.Map;
public class MapDigimon {
	//* the Lv should look like Lv1A the A will represent the pokemon like
	//agumon will be A and be lv 1 and pikachu will be B and also lv 1
	//agumon = 11 and pikachu = 12
	Map<Integer, Creature> Digimon1 = new HashMap<Integer, Creature>();
	Map<Integer, Creature> Digimon2 = new HashMap<Integer, Creature>();
	Map<Integer, Creature> Digimon3 = new HashMap<Integer, Creature>();
	Map<Integer, Creature> Digimon4 = new HashMap<Integer, Creature>();
	Map<Integer, Creature> Digimon5 = new HashMap<Integer, Creature>();
	Map<Integer, Creature> Digimon6 = new HashMap<Integer, Creature>();
	Map<Integer, Creature> Digimon7 = new HashMap<Integer, Creature>();
	Map<Integer, Creature> Digimon8 = new HashMap<Integer, Creature>();
	Map<Integer, Creature> Digimon9 = new HashMap<Integer, Creature>();
	Map<Integer, Creature> Digimon10 = new HashMap<Integer, Creature>();
		int lv= 1;
		int lv2 = 1;
		int lv3 = 1;
		int lv4 = 1;
		int lv5 = 1;
		int lv6 = 1;
		int lv7 = 1;
		int lv8 = 1;
		int lv9 = 1;
		int lv10 = 1;
	int MaxNumberOfE;
	public void put(Creature C) {
	
		if(C.getLevel()<10) {
			Digimon1.put(lv,C);
			lv++;
		}
		else if(C.getLevel()<20) {
			Digimon2.put(lv2, C);
			lv2++;
		}
		else if(C.getLevel()<30) {
			Digimon3.put(lv3, C);
			lv3++;
		}
		else if(C.getLevel()<40) {
			Digimon4.put(lv4, C);
			lv4++;
		}
		else if(C.getLevel()<50) {
			Digimon5.put(lv5, C);
			lv5++;
		}
		else if(C.getLevel()<60) {
			Digimon6.put(lv6, C);
			lv6++;
		}
		else if(C.getLevel()<70) {
			Digimon7.put(lv7, C);
			lv7++;
		}
		else if(C.getLevel()<80) {
			Digimon8.put(lv8, C);
			lv8++;
		}
		else if(C.getLevel()<90) {
			Digimon9.put(lv9, C);
			lv9++;
		}
		else if(C.getLevel()<100) {
			Digimon10.put(lv10, C);
			lv10++;
		}
	}
	public void search(String name) {
		if(name.contains("1")){
			Digimon1.get(random(lv));
		}
		else if(name.contains("2")) {
			Digimon2.get(random(lv2));
		}
		else if(name.contains("3")) {
			Digimon3.get(random(lv3));
		}
		else if(name.contains("4")) {
			Digimon4.get(random(lv4));
		}
		else if(name.contains("5")) {
			Digimon5.get(random(lv5));
		}
		else if(name.contains("6")) {
			Digimon6.get(random(lv6));
		}
		else if(name.contains("7")) {
			Digimon7.get(random(lv7));
		}
		else if(name.contains("8")) {
			Digimon8.get(random(lv8));
		}
		else if(name.contains("9")) {
			Digimon9.get(random(lv9));
		}
		else if(name.contains("10")) {
			Digimon10.get(random(lv10));
		}
	}
	public int random(int lv) {
		int Random = (int) (Math.random()*lv+ 1);
		return Random;
	}
}
