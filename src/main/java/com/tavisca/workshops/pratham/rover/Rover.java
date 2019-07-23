package com.tavisca.workshops.pratham.rover;

public class Rover {
     private int y = 0;
     private int x = 0;
     private String dir = "";
     public void setXcoordinate(int coordinatex)
     {
         this.x=coordinatex;
     }
     public void setYcoordinate(int coordinatey)
     {
        this.y=coordinatey;
     }
     public void setDirection(String direction)
     {
        this.dir=direction;
     }
     public String getDirection()
     {
        return this.dir;
     }
     public int getXcoordinate()
     {
       return this.x;
     }
     public int getYcoordinate()
     {
       return this.y;
     }
     public  void FacingNorth(char command)
     {
        switch (command) {
            case 'L':
                dir = "W";
                break;
            case 'R':
                dir = "E";
                break;
            case 'M':
                y++;
                break;
        }
     }
     public  void FacingEast(char command)
     {
        switch (command) {
            case 'L':
                dir = "N";
                break;
            case 'R':
                dir = "S";
                break;
            case 'M':
                x++;
                break;
        }
     }
     public  void FacingSouth(char command)
     {
        switch (command) {
            case 'L':
                dir = "E";
                break;
            case 'R':
                dir = "W";
                break;
            case 'M':
                y--;
                break;
        }
     }
     public  void FacingWest(char command)
     {
        switch (command) {
            case 'L':
                dir = "S";
                break;
            case 'R':
                dir = "N";
                break;
            case 'M':
                x--;
                break;
        }
     }
     public void roverMove(char command, Rover rover) {
        if (rover.getDirection().equalsIgnoreCase("N")) {
            rover.FacingNorth(command);
        } else if (rover.getDirection().equalsIgnoreCase("E")) {
            rover.FacingEast(command);
        } else if (rover.getDirection().equalsIgnoreCase("S")) {
            rover.FacingSouth(command);
        } else if (rover.getDirection().equalsIgnoreCase("W")) {
            rover.FacingWest(command);
        }
     }
}
