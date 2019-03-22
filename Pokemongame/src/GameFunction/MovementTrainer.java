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
			Chances =+ 12;// 8;
			ChoseRandom(Chances, fight);
			setDirections(up);
			return up;
		} else if (movement.equalsIgnoreCase("s")) {// move backward
			Chances =+ 12; //7;
			ChoseRandom(Chances, fight);
			setDirections(down);
			return down;
		} else if (movement.equalsIgnoreCase("a")) {// move left
			Chances =+ 12; // 9;
			ChoseRandom(Chances,fight);
			setDirections(left);
			return left;
		} else if (movement.equalsIgnoreCase("d")) {// move right
			Chances =+ 12; //8;
			ChoseRandom(Chances, fight);
			setDirections(right);
			return right;
		}

		else {
			System.out.println("this is not a movment");
			movement = input.nextLine();
			if (movement.length() < 1) {
				System.out.println("to many inputs");
				System.out.println("please try to keep the imput to one at the time");
				movement = input.nextLine();
				Move(movement, fight);
			} else {
				System.out.println("this input is invlad");
				System.out.println("the only input that can be obtain is W A S D.");
				System.out.println("Please try again");
				movement = input.nextLine();
				Move(movement, fight);
			}
		}
		return movement;
	}

	public void ChoseRandom(int Chances, Fight fight) {//, Creature enemy
		FindDigi = (int) (Math.random() * 100);
		if (Chances > FindDigi) {
			System.out.println("Pokemon detested near by");
			fight.firstMove();
			resetChances();
			

		} else {
			System.out.println("Where to go now?");
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
