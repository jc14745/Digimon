//check what i did here
public class EnemiesDigimon{
	Creature root;
	public void createRoot(Creature root) {
		this.root = root;
	}
	public Creature getRoot() {
		return this.root;
	}	
	public void add(Creature node) {
		System.out.println(node.getName());
		if(node.getLeft() != null) add(node.left);
		if(node.getRight() != null) add(node.right);
	}
	
	public Creature getEnemy(Creature C) {
		if(C.getUsed()) {
			if(random()==0) {
				getEnemy(C.getLeft());
			}
			else {
				getEnemy(C.getRight());
			}
		}
		return C;
	}
	public int random() {
		int Random = (int) (Math.random()*0+1);
		return Random;
	}

}
