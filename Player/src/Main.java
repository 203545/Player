// Dalek by Serafina France-Tribe + Sasha Zek
/* TODO:
 * I added a BUNCH of classes to lay groundwork
 * familarize  yourslef with what they do
 * make changes if needed
 * add methods if needed, I don't think we need another class
 * most important thing: make it so that turning and moving does things
 * Edit: I made turning work however I did not have enough time to figure out moving forward
 * I did however add methods and variables to assist with this. 
 * I put an if statement under the if statement for turning in which you can put the moving inside
 * I added int ifmove, getMove() (return ifMove), I added String[][] dalekPostion (THIS LAST ARRAY MAY NOT BE NEEDED)
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
   public static void main(String[] args)
   {
      Dalek dalek = new Dalek(1, 8, 1);
      World world = new World();
      world.display(dalek.getDirection(), dalek.getY(), dalek.getX(), dalek.getMove()); 
      
      Scanner keyboard = new Scanner(System.in);
      String command = "";
      
      while (!(command.equals("exit") || command.equals("e"))) //NOTE THAT CURRENTLY NONE OF THIS WORKS; add methods and classes for each, follow demo
      {
          command = keyboard.nextLine();
         
          if (command.equals("d"))
          {
              dalek.turnRight();
          }
          else if (command.equals("a"))
          {
              dalek.turnLeft();
          }
          else if (command.equals("w"))
          {
              dalek.move();
          }
            
          clearScreen();
          world.display(dalek.getDirection(), dalek.getY(), dalek.getX(), dalek.getMove()); //prints level
        }
      
  }
  
  public final static void clearScreen()
  {
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }// end of clearScreen method
}

class Dalek
{
   private int myDirection; // 1 for right, 2 for down, 3 for left, 4 for up
   private int myX; //the column that the Dalek is in
   private int myY; // the row that the Dalek in in
   private int ifMove;
                   // NOTE: myX would come afer myY. ex: Floor1[myY][myX] = "v";
   public Dalek()
    {
        myDirection = 1;
        myY = 0;
        myX = 0;
    }
    
    public Dalek(int direction, int y, int x)
    {
        myDirection = direction;
        myY = y;
        myX = x;
    }
    
    public int getDirection()
    {
      return myDirection;
    }
    
    public int getX()
    {
      return myX;
    }
    
    public int getY()
    {
      return myY;
    }
    
    public int getMove()
    {
      return ifMove;
    }
    
    public void turnRight()
    {
        myDirection += 1;
        if (myDirection == 5) //This is so myDirection doesn't go over or under its limit
         myDirection = 1;
    }
    
    public void turnLeft()
    {
        myDirection -= 1;
        if (myDirection == 0) //This is so myDirection doesn't go over or under its limit
         myDirection = 4;
    }

    //TODO: ADD COLLISSION
    // move in the current pointed direction
    public void move()
    {
      ifMove = 1;
      if (myDirection == 1) //if facing right
      {
         myX += 1;
      }
      else if (myDirection == 3) //if facing left
      {
         myX -= 1;
      }
      else if (myDirection == 2) //if facing down
      {
         myY -= 1;
      }
      else if (myDirection == 4) //if facing up
      {
         myY += 1;
      }
   }
}

class World
{
   private String[][] currentFloor;
   
   public World()
   {
      currentFloor = Levels.getFloor1();
   }
   
   public void display(int myDirection, int myY, int myX, int ifMove)
   { 
      
      int i = 0; // column number
      int k = 0; // row number
      int j;
      
      String[][] dalekPosition;
      
      for (j = 0; j < (currentFloor[0].length * currentFloor.length); j++) // Changed from Floor1 to currentFloor; we only handle one lvl at a time so > 1 loop !needed 
      {
      
         
         if ((k == myY) && (i == myX))
         {
            if (myDirection == 1)
            {
               currentFloor[k][i] = ">";
            }
            else if (myDirection == 3)
            {
               currentFloor[k][i] = "<";
            }
            else if (myDirection == 2)
            {
               currentFloor[k][i] = "v";
            }
            else if (myDirection == 4)
            {
               currentFloor[k][i] = "^";
            }
            
            if (ifMove == 1) //PUT CODE UNDER HERE
            {
            }
         }
         
         System.out.print(currentFloor[k][i]);
         i ++;
         if (i == currentFloor[0].length)
         {
            i = 0;
            k++;
            System.out.print("\n");
         }
      }
   }
}