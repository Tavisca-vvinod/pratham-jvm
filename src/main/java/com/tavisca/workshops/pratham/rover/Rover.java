package com.tavisca.workshops.pratham.rover;
import java.io.IOException;
import java.util.HashMap;

public class Rover {
     public final int y;
     public final int x;
     public final String direction;
     private static HashMap<String, String> leftMap = new HashMap<>(){{put("N","W");put("W","S");put("S","E");put("E","N");}};
     private static HashMap<String, String> rightMap = new HashMap<>(){{put("N","E");put("W","N");put("S","W");put("E","S");}};

     public Rover(int x, int y, String dir) {
        this.x = x;
        this.y = y;
         try {
             if(!dir.equals("E") && !dir.equals("W") && !dir.equals("N") && !dir.equals("S"))
             {
                 dir=null;
                 throw new IOException("Invalid direction initialisation");
             }
         }
         catch(Exception e) {
             if(e.getMessage() != null){System.out.println(e.getMessage());}
         }
         this.direction=dir;
     }
     public Rover turnLeft() {
        return new Rover(this.x,this.y,leftMap.get(this.direction));
     }
     public Rover turnRight() {
        return new Rover(this.x,this.y,rightMap.get(this.direction));
     }
     public Rover moveFront(){
         if(this.direction.equals("N"))
         {
             return new Rover(this.x,this.y+1,this.direction);
         }
         if(this.direction.equals("S"))
         {
             return new Rover(this.x,this.y-1,this.direction);
         }
         if(this.direction.equals("E"))
         {
             return new Rover(this.x+1,this.y,this.direction);
         }
         if(this.direction.equals("W"))
         {
             return new Rover(this.x-1,this.y,this.direction);
         }
         return this;
     }

     public static Rover RoverMove (String commands, Rover CurrentPosition)  {
         try {
             for (char command : commands.toCharArray()) {
                 if (command == 'L') {
                     CurrentPosition = CurrentPosition.turnLeft();
                 } else if (command == 'R') {
                     CurrentPosition = CurrentPosition.turnRight();
                 } else if (command == 'M') {
                     CurrentPosition = CurrentPosition.moveFront();
                 } else {
                     throw new IOException("Invalid symbol in command");
                 }
             }
         }
         catch(Exception e){
             CurrentPosition=new Rover(0,0,null);
             if(e.getMessage() != null){System.out.println(e.getMessage());
             }
         }
         return CurrentPosition;
     }
}
