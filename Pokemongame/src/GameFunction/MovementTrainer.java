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
Creature Enemy;
String Direction;

public void getMove() {
	
}
public String Move(String movement) {
 if(movement.equalsIgnoreCase("w")) {//move forward
	 Chances =+10;
	 ChoseRandom(Chances, Enemy);
	 setDirections(up);
	 return up;
 }
 else if(movement.equalsIgnoreCase("s")) {//move backward
	 Chances =+10;
	 ChoseRandom(Chances, Enemy);
	 setDirections(down);
	 return down;
 }
 else if(movement.equalsIgnoreCase("a")) {//move left
	 Chances =+10;
	 ChoseRandom(Chances, Enemy);
	 setDirections(left);
	 return left;
 }
 else if(movement.equalsIgnoreCase("d")) {//move right
	 Chances =+10;
	 ChoseRandom(Chances, Enemy);
	 setDirections(right);
	 return right;
 }
 
 else {
	 System.out.println("this is not a movment");
	 movement = input.nextLine();
	 if(movement.length()<1) {
		 System.out.println("to many inputs");
		 System.out.println("please try to keep the imput to one at the time");
		 movement = input.nextLine();
		 Move(movement);
	 }
	 else{
		 System.out.println("this input is invlad");
		 System.out.println("the only input that can be obtain is W A S D.");
		 System.out.println("Please try again");
		 movement = input.nextLine();
		 Move(movement);
	 }
 }
return movement;
}
public void ChoseRandom(int Chances, Creature enemy) {
	FindDigi = (int) (Math.random()*100);
	if(Chances < FindDigi) {
		enemy.setEncounter();
	}
	else {
		System.out.println("Where to go now?");
		move = input.nextLine();
		Move(move);
	}
}
public Creature getEnemy() {
	return Enemy;
}
public void setEnemy(Creature Enemy) {
	this.Enemy = Enemy;
}
public void setDirections(String D) {
	this.Direction = D;
}
public String getDirections() {
	return Direction;
}
}
