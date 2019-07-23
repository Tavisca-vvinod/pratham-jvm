package com.tavisca.workshops.pratham.rover;

public class MarsRoboRover {
	public static void main(String[] args) {

		String currentPosition = "3 3 E";
		String commands = "MMRMMRMRRM";

		Rover rover= new Rover();
		String[] positions = currentPosition.split(" ");
		rover.setXcoordinate(Integer.valueOf(positions[0]));
		rover.setYcoordinate(Integer.valueOf(positions[1]));
		rover.setDirection(positions[2]);

		for (char command : commands.toCharArray()) {
			rover.roverMove(command, rover);
		}

		System.out.println("currentPosition..." + currentPosition);
		System.out.println("commands..." + commands);
		System.out.println("newPosition..." + rover.getXcoordinate() + " " +rover.getYcoordinate() + " " + rover.getDirection());
	}
}
