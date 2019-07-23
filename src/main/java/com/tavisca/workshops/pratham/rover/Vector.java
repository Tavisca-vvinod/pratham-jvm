package com.tavisca.workshops.pratham.rover;
import java.util.HashMap;

public class Vector {
     public final int y;
     public final int x;
     public final String direction;
     private static HashMap<String, String> leftMap = new HashMap<>(){{put("N","W");put("W","S");put("S","E");put("E","N");}};
     private static HashMap<String, String> rightMap = new HashMap<>(){{put("N","E");put("W","N");put("S","W");put("E","S");}};

     public Vector(int x, int y, String dir) {
        this.x = x;
        this.y = y;
        this.direction = dir;
    }

     public Vector turnLeft() {
        return new Vector(this.x,this.y,leftMap.get(this.direction));
     }
     public Vector turnRight() {
        return new Vector(this.x,this.y,rightMap.get(this.direction));
     }
     public Vector moveFront(){
         if(this.direction.equals("N"))
         {
             return new Vector (this.x,this.y+1,this.direction);
         }
         if(this.direction.equals("S"))
         {
             return new Vector (this.x,this.y-1,this.direction);
         }
         if(this.direction.equals("E"))
         {
             return new Vector (this.x+1,this.y,this.direction);
         }
         if(this.direction.equals("W"))
         {
             return new Vector (this.x-1,this.y,this.direction);
         }
         return this;
     }
     public static Vector RoverMove(String commands,Vector CurrentPosition){
         for (char command : commands.toCharArray())
         {
             if(command=='L')
             {
                 CurrentPosition= CurrentPosition.turnLeft();
             }
             if(command=='R')
             {
                 CurrentPosition= CurrentPosition.turnRight();
             }
             if(command=='M')
             {
                 CurrentPosition= CurrentPosition.moveFront();
             }
         }
         return CurrentPosition;
     }
}
