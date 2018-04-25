
/*Name: Samuel Feye
* Class: CS140-001
* Fall 2016
* Assignment: Programming Assignment 01B
* Date: 08/30/2016
*/
public class Main
{
  public static void main(String [] args)
 {
 Circle circle = new Circle();
 Square square = new Square();

 circle.moveVertical(-80);
 circle.makeVisible();
 circle.changeSize(1);

 square.moveHorizontal(-300);
 square.moveVertical(-110);
 square.makeVisible();
 square.changeSize(1);
 
 for (int i = 0; i < 150; ++i)
 {
 circle.changeSize(i);
 square.changeSize(i);
 }
 
 }
}
