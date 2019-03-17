
public class StartPoint {

	public static void main(String[] args) {
		EnemyList list1 = new EnemyList();
		list1.createCreature();
		StartDeck deck1 = new StartDeck();
		deck1.createDeck();
		
		
		Fight fight1 = new Fight(list1.enemyDeck, deck1.newDeck);
		fight1.firstMove(0);
	}

}
