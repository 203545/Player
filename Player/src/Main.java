// Dalek by Serafina France-Tribe + Sasha Zek

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
   public static void main(String[] args)
   {
      String[][] currentFloor = {{"0"}};
      currentFloor = Levels.getFloor1();
     
      int i = 0; // column number
      int k = 0; // row number
      int j;
      for (j = 0; j < (currentFloor[0].length * currentFloor.length); j++) //Changed from Floor1 to currentFloor; we only handle one lvl at a time so > 1 loop !needed 
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