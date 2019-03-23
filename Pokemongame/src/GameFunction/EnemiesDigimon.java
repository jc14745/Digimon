package GameFunction;

public class EnemiesDigimon {
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
			node.left.resetTmpHealth();
			node.left.setFalse();
		}
		if (node.getRight() != null) {
			node.right.resetTmpHealth();
			node.right.setFalse();
		}
	}

	public Creature getEnemy(Creature C) {// add reset statment to reset all pokemon to unused
		if (C.getUsed()) {
			if (C.getLeft() != null && random() == 0) {
				C = getEnemy(C.getLeft());
			} else if (C.getRight() != null) {
				C = getEnemy(C.getRight());
			} else {
				resetNull(this.root);
				C = this.root;
			}
		} else if (C.getLeft() == null && C.getRight() == null) {
			resetNull(getRoot());
			C = this.root;
		}
		return C;
	}

	public int random() {
		int Random = (int) (Math.random() * 1);
		return Random;
	}

}
