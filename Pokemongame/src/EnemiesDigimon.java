
<<<<<<< HEAD
//check what i did here
public class EnemiesDigimon {

	Creature root;
	int NumOfEnemies=100;
	int NumOfStored;
	Creature[] Enemies = new Creature[NumOfEnemies];
	public void createRoot(Creature root) {
		this.root = root;
		Enemies[0] = this.root;
	}
	public Creature getRoot() {
		return this.root;
		
	}	
	public void add(Creature node) {
		Enemies[NumOfStored++]= node;
		System.out.println(node.getName());
		if(node.getLeft() != null) add(node.left);
		if(node.getRight() != null) add(node.right);
	}
	/*public void StoreEnemies(Creature C) {
		Creature Enemiesdigimon = new Creature();
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
	*/
	public void sortEnemies() {
		for(int pokemon = 0; pokemon < Enemies.length; pokemon++) {
				for(int pokemonCompare = pokemon+1; pokemonCompare < Enemies.length;pokemonCompare++) {
			if(Enemies[pokemon].level > Enemies[pokemonCompare].level) {
				Creature temp = null;
				temp = Enemies[pokemon];
				Enemies[pokemon] = Enemies[pokemonCompare];
				Enemies[pokemon+1] = temp;
				}
			}
		}
	}
	
}
=======
//check what i did here
public class EnemiesDigimon {

	Creature root;
	int NumOfEnemies=100;
	int NumOfStored;
	Creature[] Enemies = new Creature[NumOfEnemies];
	public void createRoot(Creature root) {
		this.root = root;
		Enemies[0] = this.root;
	}
	public Creature getRoot() {
		return this.root;
		
	}	
	public void add(Creature node) {
		Enemies[NumOfStored++]= node;
		System.out.println(node.getName());
		if(node.getLeft() != null) add(node.left);
		if(node.getRight() != null) add(node.right);
	}
	/*public void StoreEnemies(Creature C) {
		Creature Enemiesdigimon = new Creature();
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
	*/
	public void sortEnemies() {
		for(int pokemon = 0; pokemon < NumOfStored-1; pokemon++) {
				for(int pokemonCompare = pokemon+1; pokemonCompare < Enemies.length;pokemonCompare++) {
			if(Enemies[pokemon].level > Enemies[pokemonCompare].level) {
				Creature temp = null;
				temp = Enemies[pokemon];
				Enemies[pokemon] = Enemies[pokemonCompare];
				Enemies[pokemon+1] = temp;
				}
			}
		}
	}
	
}
>>>>>>> refs/remotes/origin/master
