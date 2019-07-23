package com.tavisca.workshops.pratham.rover;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {
    @Test void roverInitializesWithStartingPosition() {
        Vector r = new Vector(10,20,"N");
        assertEquals(r.x,10);
        assertEquals(r.y,20);
        assertEquals(r.direction,"N");
    }
    @Test void roverCanRotateLeftFromNorth() {
        Vector r = new Vector(10,20,"N");
        Vector newVector=r.turnLeft();
        assertEquals("W",newVector.direction);
    }
    @Test void roverCanRotateLeftFromWest() {
        Vector r = new Vector(10,20,"W");
        Vector newVector=r.turnLeft();
        assertEquals("S",newVector.direction);
    }
    @Test void roverCanRotateLeftFromSouth() {
        Vector r = new Vector(10,20,"S");
        Vector newVector=r.turnLeft();
        assertEquals("E",newVector.direction);
    }
    @Test void roverCanRotateLeftFromEast() {
        Vector r = new Vector(10,20,"E");
        Vector newVector=r.turnLeft();
        assertEquals("N",newVector.direction);
    }
    @Test void roverCanRotateRightFromNorth() {
        Vector r = new Vector(10,20,"N");
        Vector newVector=r.turnRight();
        assertEquals("E",newVector.direction);
    }
    @Test void roverCanRotateRightFromWest() {
        Vector r = new Vector(10,20,"W");
        Vector newVector=r.turnRight();
        assertEquals("N",newVector.direction);
    }
    @Test void roverCanRotateRightFromSouth() {
        Vector r = new Vector(10,20,"S");
        Vector newVector=r.turnRight();
        assertEquals("W",newVector.direction);
    }
    @Test void roverCanRotateRightFromEast() {
        Vector r = new Vector(10,20,"E");
        Vector newVector=r.turnRight();
        assertEquals("S",newVector.direction);
    }
    @Test void roverCanMoveNorth() {
        Vector r = new Vector(10,20,"N");
        Vector newVector=r.moveFront();
        assertEquals(21,newVector.y);
    }
    @Test void roverCanMoveSouth() {
        Vector r = new Vector(10,20,"S");
        Vector newVector=r.moveFront();
        assertEquals(19,newVector.y);
    }
    @Test void roverCanMoveEast() {
        Vector r = new Vector(10,20,"E");
        Vector newVector=r.moveFront();
        assertEquals(11,newVector.x);
    }
    @Test void roverCanMoveWest() {
        Vector r = new Vector(10,20,"W");
        Vector newVector=r.moveFront();
        assertEquals(9,newVector.x);
    }
    @Test void roverMovesFrom_2_2_E_To_2_2_E_by_MRRMRR() {
        String commands = "MRRMRR";
        Vector rover = new Vector(2,2,"E");
        var roverNewPosition = Vector.RoverMove(commands,rover);
        assertEquals(2,roverNewPosition.x);
        assertEquals(2,roverNewPosition.y);
        assertEquals("E",roverNewPosition.direction);
    }
}
