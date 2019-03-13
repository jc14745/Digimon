
public class EnemiesDigimon  {
	int NumOfEnemies=100;
	int NumOfStored;
	EnemiesDigimonCreation leftChild;
	EnemiesDigimonCreation rightChild;
	EnemiesDigimonCreation root;
	EnemiesDigimonCreation[] Enemies = new EnemiesDigimonCreation[NumOfEnemies];
	public void StoreEnemies(EnemiesDigimonCreation C) {
		EnemiesDigimonCreation Enemiesdigimon = new EnemiesDigimonCreation();
		if(root == null) {
			root = C;
			Enemies[NumOfStored]= root;	
		}
		else {
			if(Enemies[NumOfStored].level < C.level && Enemies[(NumOfStored*2)+1]== null) {
				Enemiesdigimon = leftChild;
				Enemiesdigimon.setArr((NumOfStored*2)+1);
				Enemies[Enemiesdigimon.getNumber()] = Enemiesdigimon;
				
			}
			else {
				if(Enemies[NumOfStored].level < C.level && Enemies[(NumOfStored*2)+2]== null) {
					Enemiesdigimon = rightChild;
					Enemiesdigimon.setArr((NumOfStored*2)+2);
					Enemies[Enemiesdigimon.getNumber()] = Enemiesdigimon; 
				}
			}
		}
		if(Enemies[(NumOfStored*2)+1]!= null && Enemies[(NumOfStored*2)+2]!=null) {
			NumOfStored++;
			StoreEnemies(C);
		}
	}
	public void sortEnemies() {
		for(int pokemon = 0; pokemon < Enemies.length; pokemon++) {
				for(int pokemonCompare = pokemon+1; pokemonCompare < Enemies.length;pokemonCompare++) {
			if(Enemies[pokemon].level > Enemies[pokemonCompare].level) {
				EnemiesDigimonCreation temp = null;
				temp = Enemies[pokemon];
				Enemies[pokemon] = Enemies[pokemonCompare];
				Enemies[pokemon+1] = temp;
				}
				}
		}
	}
	
}