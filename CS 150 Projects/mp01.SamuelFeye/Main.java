
/**
 * File: mp01.SamuelFeye
 * Name: Samuel Feye
 * Revised:  21.01.2017
 * Course: CS150 - Intro to Computing II
 * Desc: allows you to add or subtract angle and convert 
 *       fractional angles to DMS
 */
public class Main
{
    public static void main (String [] args)
    {
        Angle angle0 = new Angle ();
        System.out.println("angle0 = " + angle0.toString());
        
        Angle angleAcute = new Angle (45.123);
        
        System.out.println("angleAcute = " + angleAcute.toString());
        
        Angle angleObtuse = new Angle (101, 20, 34);
        System.out.println("angleObtuse = " + angleObtuse.toString());
        System.out.println();
        
        System.out.println("Current DMS of angleAcute: ");
        System.out.println(angleAcute.getDegrees());
        System.out.println(angleAcute.getMinutes());
        System.out.println(angleAcute.getSeconds());
        
        System.out.println();
        System.out.printf("Updated angleObtuse as a fraction:  %.4f\n", angleObtuse.getFractionalAngle());
        System.out.println();
        
        angleAcute.setDegrees(30);
        System.out.println("angleAcute updated degrees: " + angleAcute.toString());
        angleAcute.setMinutes(30);
        System.out.println("angleAcute updated minutes: " + angleAcute.toString());
        angleAcute.setSeconds(30);
        System.out.println("Fully updated angleAcute: " + angleAcute.toString());
        System.out.println();
        
        angleObtuse.setFractionalAngle(167.345);
        System.out.println("Converting angleObtuse from fraction to DMS: " + angleObtuse.toString());
        System.out.println();
        
        angleObtuse.setAngle (140, 45, 45.5);
        System.out.println("Setting new DMS to angleObtuse: " + angleObtuse.toString());
        System.out.println();
        
        System.out.printf("Computing angleAcute + angleObtuse: ");
        Angle sum = angleAcute.addAngle(angleObtuse);
        System.out.printf(sum.toString());
        System.out.println();
        
        System.out.printf("Computing angleAcute - angleObtuse: ");
        Angle difference = angleAcute.subtractAngle(angleObtuse);
        System.out.printf(difference.toString());
        System.out.println();
        
        
    }
}
