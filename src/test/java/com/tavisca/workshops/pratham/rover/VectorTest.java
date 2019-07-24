package com.tavisca.workshops.pratham.rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {
    @Test void roverInitializesWithStartingPosition() {
        Rover r = new Rover(10,20,"N");
        assertEquals(r.x,10);
        assertEquals(r.y,20);
        assertEquals(r.direction,"N");
    }
    @Test void IllegalDirectionInitialisation(){
       Rover roverNewPosition = new Rover(2,2,"K");
       assertNull(roverNewPosition.direction);
    }
    @Test void roverCanRotateLeftFromNorth() {
        Rover r = new Rover(10,20,"N");
        Rover newVector=r.turnLeft();
        assertEquals("W",newVector.direction);
    }
    @Test void roverCanRotateLeftFromWest() {
        Rover r = new Rover(10,20,"W");
        Rover newVector=r.turnLeft();
        assertEquals("S",newVector.direction);
    }
    @Test void roverCanRotateLeftFromSouth() {
        Rover r = new Rover(10,20,"S");
        Rover newVector=r.turnLeft();
        assertEquals("E",newVector.direction);
    }
    @Test void roverCanRotateLeftFromEast() {
        Rover r = new Rover(10,20,"E");
        Rover newVector=r.turnLeft();
        assertEquals("N",newVector.direction);
    }
    @Test void roverCanRotateRightFromNorth() {
        Rover r = new Rover(10,20,"N");
        Rover newVector=r.turnRight();
        assertEquals("E",newVector.direction);
    }
    @Test void roverCanRotateRightFromWest() {
        Rover r = new Rover(10,20,"W");
        Rover newVector=r.turnRight();
        assertEquals("N",newVector.direction);
    }
    @Test void roverCanRotateRightFromSouth() {
        Rover r = new Rover(10,20,"S");
        Rover newVector=r.turnRight();
        assertEquals("W",newVector.direction);
    }
    @Test void roverCanRotateRightFromEast() {
        Rover r = new Rover(10,20,"E");
        Rover newVector=r.turnRight();
        assertEquals("S",newVector.direction);
    }
    @Test void roverCanMoveNorth() {
        Rover r = new Rover(10,20,"N");
        Rover newVector=r.moveFront();
        assertEquals(21,newVector.y);
    }
    @Test void roverCanMoveSouth() {
        Rover r = new Rover(10,20,"S");
        Rover newVector=r.moveFront();
        assertEquals(19,newVector.y);
    }
    @Test void roverCanMoveEast() {
        Rover r = new Rover(10,20,"E");
        Rover newVector=r.moveFront();
        assertEquals(11,newVector.x);
    }
    @Test void roverCanMoveWest() {
        Rover r = new Rover(10,20,"W");
        Rover newVector=r.moveFront();
        assertEquals(9,newVector.x);
    }
    @Test void IllegalCommandInput(){
        String commands = "MABC!@";
        Rover roverNewPosition = new Rover(2,2,"E");
        roverNewPosition = Rover.RoverMove(commands, roverNewPosition);
        assertNull(roverNewPosition.direction);
    }
    @Test void EmptyCommandInput(){
        String commands = "";
        Rover roverNewPosition = new Rover(2,2,"E");
        roverNewPosition = Rover.RoverMove(commands, roverNewPosition);
        assertEquals(2,roverNewPosition.x);
        assertEquals(2,roverNewPosition.y);
        assertEquals("E",roverNewPosition.direction);
    }
    @Test void roverMovesFromFirstQuadrantToFirstQuadrant() {
        String commands = "LLMMMMLL";
        Rover roverNewPosition = new Rover(2,2,"E");
        roverNewPosition = Rover.RoverMove(commands, roverNewPosition);
        assertEquals(-2,roverNewPosition.x);
        assertEquals(2,roverNewPosition.y);
        assertEquals("E",roverNewPosition.direction);
    }
    @Test void roverMovesFromFirstQuadrantToSecondQuadrant() {
        String commands = "MRRMRR";
        Rover roverNewPosition = new Rover(2,2,"E");
        roverNewPosition = Rover.RoverMove(commands, roverNewPosition);
        assertEquals(2,roverNewPosition.x);
        assertEquals(2,roverNewPosition.y);
        assertEquals("E",roverNewPosition.direction);
    }
    @Test void roverMovesFromFirstQuadrantToThirdQuadrant() {
        String commands = "RMMMMRMMMMLL";
        Rover roverNewPosition = new Rover(2,2,"E");
        roverNewPosition = Rover.RoverMove(commands, roverNewPosition);
        assertEquals(-2,roverNewPosition.x);
        assertEquals(-2,roverNewPosition.y);
        assertEquals("E",roverNewPosition.direction);
    }
    @Test void roverMovesFromFirstQuadrantToFourthQuadrant() {
        String commands = "RMMMML";
        Rover roverNewPosition = new Rover(2,2,"E");
        roverNewPosition = Rover.RoverMove(commands, roverNewPosition);
        assertEquals(2,roverNewPosition.x);
        assertEquals(-2,roverNewPosition.y);
        assertEquals("E",roverNewPosition.direction);
    }
    @Test void someStressTesting(){
        String commands1 = "LLMMMMLL";
        String commands2 = "RMMMML";
        String commands3 = "RMMMMRMMMMLL";
        String commands4 = "MRRMRRM";
        Rover roverNewPosition = new Rover(2,2,"E");
        roverNewPosition = Rover.RoverMove(commands1, roverNewPosition);
        roverNewPosition= Rover.RoverMove(commands2,roverNewPosition);
        roverNewPosition= Rover.RoverMove(commands3,roverNewPosition);
        roverNewPosition= Rover.RoverMove(commands4,roverNewPosition);
        assertEquals(-5,roverNewPosition.x);
        assertEquals(-6,roverNewPosition.y);
        assertEquals("E",roverNewPosition.direction);
    }
}
