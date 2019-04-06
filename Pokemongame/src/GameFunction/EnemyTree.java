package GameFunction;

public class EnemyTree {
	Creature root;

	public void createRoot(Creature root) {
		this.root = root;
	}

	public Creature getRoot() {
		return this.root;
	}

	public void traverse(Creature node) {
		System.out.println(node.getName());
		if (node.getLeft() != null)
			traverse(node.getLeft());
		if (node.getRight() != null)
			traverse(node.getRight());
	}

	public void resetNull(Creature node) {// resets all enemy back to full health and allows them to be chosen
		if (node != null) {
			node.resetTmpHealth();
			node.setFalse();
		}
		if (node.getLeft() != null) {
			node.getLeft().resetTmpHealth();
			node.getLeft().setFalse();
			resetNull(node.getLeft());
		}
		if (node.getRight() != null) {
			node.getLeft().resetTmpHealth();
			node.getLeft().setFalse();
			resetNull(node.getRight());
		}
	}

	
	
	public Creature getEnemy(Creature C) {// add reset statement to reset all pokemon to unused
		
		if (C.getUsed() == true) {
			if (C.getLeft() != null && random()%2 == 0) {
				C = getEnemy(C.getLeft());
			} else if (C.getRight() != null) {
				C = getEnemy(C.getRight());
			} 
		}	
		return C;
	}

	public int random() {
		int Random = (int) (Math.random() * 100);
		return Random;
	}

}
