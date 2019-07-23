package com.tavisca.workshops.pratham.rover;

public class MarsRoboRover {
	public static void main(String[] args) {

		String currentPosition = "3 3 E";
		String commands = "MMRMMRMRRM";

		String[] positions = currentPosition.split(" ");
		Vector rover = new Vector(Integer.valueOf(positions[0]),Integer.valueOf(positions[1]),positions[2]);

		var roverNewPosition = Vector.RoverMove(commands,rover);

		System.out.println("currentPosition..." + currentPosition);
		System.out.println("commands..." + commands);
		System.out.println("newPosition..." + roverNewPosition.x + " " +roverNewPosition.y + " " + roverNewPosition.direction);
	}
}
