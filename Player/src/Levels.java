// Dalek by Sasha Zek + Serafina France-Tribe

/* add color?
* _ or | is a wall
* " " is nothing
* > is a dalek, > is facing east, < is facing west, ^ is facing north, v is facing down
* c is the companion you need to exterminate
* D is the Doctor, exterminate
* s is stairs up
* p is a general enemy
*/

public class Levels
{
   
   public static String[][] getFloor1()
   {
      String[][] Floor1 = {
      {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"}, 
      {"|", " ", " ", " ", " ", " ", " ", " ", "c", "s", "|"},
      {"|", " ", "_", "_", "_", "_", "_", "_", "_", "_", "|"},
      {"|", " ", "|", " ", " ", " ", "|", " ", " ", " ", "|"},
      {"|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|"},
      {"|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|"},
      {"|", " ", " ", " ", "|", " ", " ", " ", "|", " ", "|"},
      {"|", "_", "_", "_", "|", "_", "_", "_", "|", " ", "|"},
      {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
      {"|", "_", "_", "_", "_", "_", "_", "_", "_", "_", "|"}};
      
      return Floor1;
  }
  
  //rn there is error where code prints both floors, idky it is happening, will eventually bring lvl 2 back if enough time
  /* public static String[][] getFloor2()
  {
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
      
      return Floor2;
   }*/
}