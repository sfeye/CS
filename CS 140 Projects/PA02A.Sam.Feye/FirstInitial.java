import java.util.ArrayList;
/*Name: Samuel Feye
* Class: CS140-001
* Fall 2016
* Assignment: Programming Assignment 2A
* Date: 09/19/2016
*/
public class FirstInitial
{
    private ArrayList<Circle> circles = new ArrayList <> ();
    Circle initial;
    public FirstInitial ()
    {
        int initialx = 0;
        int initialy = 0;
        int SPACE = 34;
        
        for (int i =0; i < 5; i++)
        {
            initial = new Circle ();
            initial.makeVisible();
            initial.moveHorizontal(-180);
            initial.moveVertical(i*SPACE);
            
            if (i == 2)
            {
                initialx = initial.xPosition;
                initialy = initial.yPosition;
            }
            
            circles.add(initial);
        }
        
        for (int i = 0; i < 4; i++)
        {
            initial = new Circle ();
            initial.makeVisible();
            initial.moveHorizontal(initialx - initial.xPosition);
            initial.moveHorizontal(i * SPACE);
            
            circles.add(initial);
            
        }
        
        for (int i = 0; i < 3; i++)
        {
            initial = new Circle ();
            initial.makeVisible();
            initial.moveHorizontal(initialx - initial.xPosition);
            initial.moveHorizontal(i * SPACE);
            initial.moveVertical(68);
            
            circles.add(initial);
            
        }
            
    }
    
    public void changeInitialColor (String color)
    {
        circles.forEach ((Circle initial) ->
        (initial.changeColor(color)));
    }
    
    public void moveInitialHorizontal (int num)
    {
        circles.forEach ((Circle initial) ->
        (initial.moveHorizontal(num)));
    }
    
    public void moveInitialVertical (int num)
    {
        circles.forEach ((Circle initial) ->
        (initial.moveVertical(num)));
    }

}
