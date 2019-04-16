package GameFunction;

public class EnemyTree {
	Creature root;

	public void createRoot(Creature root) {
		this.root = root;
	}

	public Creature getRoot() {
		return this.root;
	}

	public void traverse(Creature node) {//traversal method to test if the pokemon were placed in the right order
		System.out.println(node.getName());
		if (node.getLeft() != null) traverse(node.getLeft());
		if (node.getRight() != null) traverse(node.getRight());
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

	public int random() {//produces a random number that is then used to randomly select the left or right node in the getEnemy method
		int Random = (int) (Math.random() * 100);
		return Random;
	}

}
