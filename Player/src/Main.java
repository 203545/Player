// Dalek by Serafina France-Tribe + Sasha Zek
/* TODO:
 * I added a BUNCH of classes to lay groundwork
 * familarize  yourslef with what they do
 * make changes if needed
 * add methods if needed, I don't think we need another class
 * JAN 10 EDIT:
 * - Movement now works, I fixed it by moving the if statement and putting the editing currentFloor above for loop
 * - If you want the long explanaion what what I did and why it worked you can ask me after school
 * TODO:
 * - Just add text events
 */ 

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
   public static void main(String[] args)
   {
      Dalek dalek = new Dalek(1, 8, 1, 0);
      World world = new World();  
      
      Scanner keyboard = new Scanner(System.in);
      String command = "";
      
      System.out.println("Welcome to Dalek Destruction! You will be playing as a Dalek trying to exterminate the companion.\nGet to the companion to obtain the key, and then get to the stairwell to proceed!\n_ or | is a wall; ' ' is nothing\n> is a dalek; > is facing east, < is facing west, ^ is facing north, v is facing down\nc is the companion you need to exterminate; s is stairs up\nw is forward, a turns left, s is backward, and d turns right");
      
      while (!(command.equals("exit") || command.equals("e")))
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
          world.display(dalek.getDirection(), dalek.getY(), dalek.getX(), dalek.getMove(), dalek); //prints level
          dalek.setMove(0);
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
        ifMove = 0;
    }
    
    public Dalek(int direction, int y, int x, int move)
    {
        myDirection = direction;
        myY = y;
        myX = x;
        ifMove = move;
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
    
    public void setX(int X)
    {
      myX = X;
    }
    
    public void setY(int Y)
    {
      myY = Y;
    }
    
    public void setMove(int move)
    {
      ifMove = move;
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
         myY += 1;
      }
      else if (myDirection == 4) //if facing up
      {
         myY -= 1;
      }
   }
}

class World
{
   private String[][] currentFloor;
   private int myKey;
   private int enemyY;
   private int enemyX;
   
   public World()
   {
      currentFloor = Levels.getFloor1();
      myKey = 0;
      enemyY = 0;
      enemyX = 0;
   }
   
   public void setKey(int key)
   {
      myKey = key;
   }
   
   public void setEnemy(int Y, int X)
   {
      enemyY = Y;
      enemyX = X;
   }
   
   public void findEnemies(String[][] currentFloor)
   {
      int i = 0; // column number
      int k = 0; // row number
      int j;
      
      for (j = 0; j < (currentFloor[0].length * currentFloor.length); j++)
      {   
         if (currentFloor[k][i].equals("p"))
         {
            setEnemy(k, i);
            break;
         }
         
         i++;
         if (i == currentFloor[k].length)
         {
            i = 0;
            k++;
         }
      }
   } 
      
      
   
   public void display(int myDirection, int myY, int myX, int ifMove, Dalek dalek)
   { 
      
      int i = 0; // column number
      int k = 0; // row number
      int j;
      
      String dalekPosition = " "; //Variable to temp save the dalek's direc (therefore able to see future pos) for shorter code
      int previousPosY = 0; //Variables that goes hand-in-hand with dalekPosition to store the dalek's previous pos; should only be set to +-1
      int previousPosX = 0;
      
      if (myDirection == 1)
      {
         dalekPosition = ">";
         previousPosX = -1;  //This will print a blank line where the dalek used to be
      }
      else if (myDirection == 3)
      {
         dalekPosition = "<";
         previousPosX = 1;
      }
      else if (myDirection == 2)
      {
         dalekPosition = "v";
         previousPosY = -1;
      }
      else if (myDirection == 4)
      {
         dalekPosition = "^";
         previousPosY = 1;
      }
      
      findEnemies(currentFloor); //Keeps the location of and enemy, updates each time player moves
       
      if (currentFloor[myY][myX] == currentFloor[enemyY][enemyX])
      {
         System.out.println("You come into contact with bystander Tom. Before he can run, you use your plunger and he's a goner.");
         currentFloor[myY][myX] = dalekPosition;
         currentFloor[myY + previousPosY][myX + previousPosX] = " ";
      }
      else if ((ifMove == 1) && ((currentFloor[myY][myX].equals("_")) || (currentFloor[myY][myX].equals("|"))))
      {
         System.out.println("Make sure to stay within the walls!");
         currentFloor[myY + previousPosY][myX + previousPosX] = dalekPosition;
         myX = myX + previousPosX;
         myY = myY + previousPosY;
         dalek.setX(myX);
         dalek.setY(myY);
      }
      else if ((ifMove == 1) && (currentFloor[myY][myX].equals("c"))) //If player finds companion, the program sends a message and terminates
      {
         System.out.println("Congratulations, you found the companion!\nYou have obtained the key!");
         currentFloor[myY][myX] = dalekPosition;
         currentFloor[myY + previousPosY][myX + previousPosX] = " ";
         previousPosY = 0;
         previousPosX = 0;
         setKey(1);
      }
      else if ((ifMove == 1) && (currentFloor[myY][myX].equals("s")))
      {
         currentFloor[myY][myX] = dalekPosition;
         if (myKey == 1)
         {
            System.out.println("You have won!");
            currentFloor[myY + previousPosY][myX + previousPosX] = " ";
            previousPosY = 0;
            previousPosX = 0;
            System.exit(0); //Terminates program; temporary if we add in other levels
         }
        else
        {
         System.out.println("Woah there! You don't have the key yet!\nYou have to exterminate the companion still partner");
         currentFloor[myY][myX] = "s";
         myX = myX + previousPosX;
         myY = myY + previousPosY;
         dalek.setX(myX);
         dalek.setY(myY);
        }
     }
      else if (ifMove == 1)
      {
         currentFloor[myY][myX] = dalekPosition;
         currentFloor[myY + previousPosY][myX + previousPosX] = " ";
         previousPosY = 0;
         previousPosX = 0;
      }
      else if (ifMove == 0)
      {
         currentFloor[myY][myX] = dalekPosition;
         previousPosY = 0;
         previousPosX = 0;
      } 
      
      
      //DO NOT EDIT ANYTHING UNDER HERE, DO NOT ADD ANYTHING, ANYTHING LIKE COLISSION SHOULD BE ADDED ABOVE
      for (j = 0; j < (currentFloor[0].length * currentFloor.length); j++) // Changed from Floor1 to currentFloor; we only handle one lvl at a time so > 1 loop !needed 
      {
      
         
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
