package GameFunction;

public class EnemiesDigimon{
	Creature root;
	public void createRoot(Creature root) {
		this.root = root;
	}
	public Creature getRoot() {
		return this.root;
	}	
	public void resetNull(Creature node) {
		if(node != null) { 
			node.resetTmpHealth();
			node.setFalse();
		}
		if(node.getLeft() != null) { 
			node.left.resetTmpHealth();
			node.left.setFalse();
			}
		if(node.getRight() != null) {  
			node.right.resetTmpHealth();
			node.right.setFalse();
			}
	}
	
	public Creature getEnemy(Creature C) {//add reset statment to reset all pokemon to unused
		if(C.getUsed()) {
			if(C.getLeft() != null && random()==0) {
				C = getEnemy(C.getLeft());
			}
			else if(C.getRight() != null){
				C = getEnemy(C.getRight());
			}
			else {
				resetNull(this.root);
				C = this.root;
			}
		}
		else if(C.getLeft() == null && C.getRight() == null) {
				resetNull(getRoot());
				C = this.root;
		}
		return C;
	}
	public int random() {
		int Random = (int) (Math.random()*0+1);
		return Random;
	}

}
