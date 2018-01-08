// Dalek by Serafina + Spencer

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
   public static void main(String[] args)
   {
      /* add color?
       * _ or | is a wall
       * " " is nothing
       * > is a dalek, > is facing east, < is facing west, ^ is facing north, v is facing down
       * c is the companion you need to exterminate
       * D is the Doctor, exterminate
       * s is stairs up
       * p is a general enemy
       */
      String[][] Floor1 = {
      {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"}, 
      {"|", " ", " ", " ", " ", " ", " ", " ", "c", "s", "|"},
      {"|", " ", "_", "_", "_", "_", "_", "_", "_", "_", "|"},
      {"|", " ", "|", " ", " ", " ", "|", " ", " ", " ", "|"},
      {"|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|"},
      {"|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|"},
      {"|", " ", " ", " ", "|", " ", " ", " ", "|", " ", "|"},
      {"|", "_", "_", "_", "|", "_", "_", "_", "|", " ", "|"},
      {"|", ">", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
      {"|", "_", "_", "_", "_", "_", "_", "_", "_", "_", "|"}};
     
      int i = 0; // column number
      int k = 0; // row number
      int j;
      for (j = 0; j < (Floor1[0].length * Floor1.length); j++)
      {
         System.out.print(Floor1[k][i]);
         i ++;
         if (i == Floor1[0].length)
         {
            i = 0;
            k++;
            System.out.print("\n");
         }
      }
      
      
      
      
      
      
      
      
      
      String[][] Floor2 = {
      {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"}, 
      {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
      {"|", " ", " ", "_", "_", "_", "_", "_", " ", " ", " ", "|", " ", " ", "|"},
      {"|", " ", " ", "|", " ", " ", "|", " ", " ", " ", " ", "|", " ", "p", "|"},
      {"|", " ", " ", "|", " ", " ", "|", " ", " ", " ", " ", "|", " ", " ", "|"},
      {"|", "s", " ", "|", " ", " ", "|", " ", " ", " ", " ", "|", "_", "_", "|"},
      {"|", "_", "_", "|", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", "|"},
      {"|", " ", " ", " ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", "|"},
      {"|", " ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", "_", "_", "|"},
      {"|", " ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
      {"|", " ", " ", " ", "|", "_", "_", "|", " ", " ", " ", " ", " ", " ", "|"},
      {"|", " ", " ", " ", " ", " ", "c", "|", " ", " ", " ", "|", " ", " ", "|"},
      {"|", "_", "_", "_", "_", "_", "_", "|", " ", " ", " ", "|", "_", "_", "|"},
      {"|", ">", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
      {"|", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "|"}};
     
      i = 0; // column number
      k = 0; // row number
      for (j = 0; j < (Floor2[0].length * Floor2.length); j++)
      {
         System.out.print(Floor2[k][i]);
         i ++;
         if (i == Floor2[0].length)
         {
            i = 0;
            k++;
            System.out.print("\n");
         }
      }
      
  }
}