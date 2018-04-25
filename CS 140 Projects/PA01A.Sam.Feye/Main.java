
/*Name: Samuel Feye
* Class: CS140-00
* Fall 2016
* Assignment: Programming Assignment 01A
* Date: 08/25/2016
*/

public class Main
{
    public static void main(String [] args)
    {
        //Top circle of S initial
        Circle topColorS = new Circle ();
        topColorS.makeVisible ();
        topColorS.changeColor ("red");
        topColorS.changeSize (200);
        topColorS.moveHorizontal (-500);
        topColorS.moveVertical (-100);
        
        //White mask on top of top circle of S initial
        Circle topMaskS = new Circle ();
        topMaskS.makeVisible ();
        topMaskS.changeColor ("white");
        topMaskS.changeSize (150);
        topMaskS.moveHorizontal (-450);
        topMaskS.moveVertical (-55);
        
        //Bottom circle of S initial
        Circle bottomColorS = new Circle ();
        bottomColorS.makeVisible ();
        bottomColorS.changeColor ("red");
        bottomColorS.changeSize (200);
        bottomColorS.moveHorizontal (-500);
        bottomColorS.moveVertical (90);
        
        //White mask on top of bottom circle of S initial
        Circle bottomMaskS = new Circle ();
        bottomMaskS.makeVisible ();
        bottomMaskS.changeColor ("white");
        bottomMaskS.changeSize (151);
        bottomMaskS.moveHorizontal (-500);
        bottomMaskS.moveVertical (95);
        
        //The C initial bottom layer that makes the C under the mask
        Circle cInitialColor = new Circle ();
        cInitialColor.makeVisible ();
        cInitialColor.changeColor ("blue");
        cInitialColor.changeSize (250);
        cInitialColor.moveHorizontal (-240);
        cInitialColor.moveVertical (-20);
        
        //Layered mask for the C initial
        Circle cInitialMask = new Circle ();
        cInitialMask.makeVisible ();
        cInitialMask.changeColor ("white");
        cInitialMask.changeSize (210);
        cInitialMask.moveHorizontal (-190);
        cInitialMask.moveVertical (0);
        
        //Top square for the top 50% of F initial
        Square topColorF = new Square ();
        topColorF.makeVisible ();
        topColorF.changeColor ("green");
        topColorF.changeSize (200);
        topColorF.moveHorizontal (70);
        topColorF.moveVertical (-50);
        
        //Bottom square for the bottom 50% of F initial
        Square bottomColorF = new Square ();
        bottomColorF.makeVisible ();
        bottomColorF.changeColor ("green");
        bottomColorF.changeSize (200);
        bottomColorF.moveHorizontal (70);
        bottomColorF.moveVertical (100);
        
        //White mask, combines with topMaskF2 to make the top F blank spot
        Square topMaskF1 = new Square ();
        topMaskF1.makeVisible ();
        topMaskF1.changeColor ("white");
        topMaskF1.changeSize (90);
        topMaskF1.moveHorizontal (120);
        topMaskF1.moveVertical (0);
        
        //White mask, next to topMaskF1 to complete top F blank spot
        Square topMaskF2 = new Square ();
        topMaskF2.makeVisible ();
        topMaskF2.changeColor ("white");
        topMaskF2.changeSize (90);
        topMaskF2.moveHorizontal (200);
        topMaskF2.moveVertical (0);
        
        //Big white mask, near bottom (right) of F initial
        Square bottomMaskF = new Square ();
        bottomMaskF.makeVisible ();
        bottomMaskF.changeColor ("white");
        bottomMaskF.changeSize (180);
        bottomMaskF.moveHorizontal (120);
        bottomMaskF.moveVertical (130);
        
        //Small adjustment to make the bottom rectangle of F initial shorter than the top
        Square editMaskF = new Square ();
        editMaskF.makeVisible ();
        editMaskF.changeColor ("white");
        editMaskF.changeSize (50);
        editMaskF.moveHorizontal (220);
        editMaskF.moveVertical (90);
        

    }
}
