package GameFunction;

import java.util.Scanner;

public class MovementTrainer {
	String up = "up";
	String down = "down";
	String left = "left";
	String right = "right";
	Scanner input = new Scanner(System.in);
	int Chances = 10;
	int FindDigi;
	String move;
	String Direction;

	public String Move(String movement, Fight fight) {
		if (movement.equalsIgnoreCase("w")) {// move forward
			Chances =+ 8;
			ChoseRandom(Chances, fight);
			setDirections(up);
			return up;
		} else if (movement.equalsIgnoreCase("s")) {// move backward
			Chances =+ 7;
			ChoseRandom(Chances, fight);
			setDirections(down);
			return down;
		} else if (movement.equalsIgnoreCase("a")) {// move left
			Chances =+ 9;
			ChoseRandom(Chances,fight);
			setDirections(left);
			return left;
		} else if (movement.equalsIgnoreCase("d")) {// move right
			Chances =+ 8; 
			ChoseRandom(Chances, fight);
			setDirections(right);
			return right;
		}

		else {
			System.out.println("This is not a movment.");
			movement = input.nextLine();
			if (movement.length() < 1) {
				System.out.println("Too many inputs.");
				System.out.println("Please try to keep the input to one at the time.");
				movement = input.nextLine();
				Move(movement, fight);
			} else {
				System.out.println("This input is invalid.");
				System.out.println("The only input that can be accepted is W A S D.");
				System.out.println("Please try again.");
				movement = input.nextLine();
				Move(movement, fight);
			}
		}
		return movement;
	}

	public void ChoseRandom(int Chances, Fight fight) { //checks to see if there is an encounter
		FindDigi = (int) (Math.random() * 100);
		if (Chances > FindDigi) {
			System.out.println("Pokemon detected near by.");
			fight.firstMove();
			resetChances();
			
		} else {
			System.out.println("Where to go now?");//there is no encounter and continues to move
			move = input.nextLine();
			Move(move, fight);
		}
	}

	public void setDirections(String D) {
		this.Direction = D;
	}
	public String getDirections() {
		return Direction;
	}
	public void resetChances() {
		Chances = 10;
	}
}
