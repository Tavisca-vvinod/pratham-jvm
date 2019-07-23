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
     public void roverMove(char command) {
        if (this.getDirection().equalsIgnoreCase("N")) {
            this.FacingNorth(command);
        } else if (this.getDirection().equalsIgnoreCase("E")) {
            this.FacingEast(command);
        } else if (this.getDirection().equalsIgnoreCase("S")) {
            this.FacingSouth(command);
        } else if (this.getDirection().equalsIgnoreCase("W")) {
            this.FacingWest(command);
        }
     }
     private void FacingNorth(char command)
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
     private  void FacingEast(char command)
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
     private  void FacingSouth(char command)
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
     private  void FacingWest(char command)
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
}
