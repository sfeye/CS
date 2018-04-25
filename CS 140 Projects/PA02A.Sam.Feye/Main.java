import java.util.Scanner;
/*Name: Samuel Feye
* Class: CS140-001
* Fall 2016
* Assignment: Programming Assignment 2A
* Date: 09/19/2016
*/
public class Main
{
    public static void main(String [] args)
    {
      final Scanner scanner = new Scanner (System.in);
        final FirstInitial finitial = new FirstInitial ();
        
        System.out.println("Choose from the following:");
        System.out.println("1. Change color");
        System.out.println("2. Move horizontally");
        System.out.println("3. Move vertically");
        System.out.println("");
        System.out.println("Enter selection:");
        
        int selection = scanner.nextInt();
        
        if (selection == 1)
        {
            System.out.println();
            System.out.println("Valid colors are red, yellow, blue, green,magenta and black.");
            System.out.println("Change color to:");
            String color = scanner.next();
            finitial.changeInitialColor(color);
            
        }
        
        else if (selection == 2)
        {
            System.out.println("Change position to:");
            int distance = scanner.nextInt();
            finitial.moveInitialHorizontal(distance);
            
        }
        
        else if (selection == 3)
        {
            System.out.println("Change position to:");
            int distance = scanner.nextInt();
            finitial.moveInitialVertical(distance);
            
        }
        
        else if (selection > 3)
        {
            System.out.println ("Error: not an option");
        }
        System.out.println("Try again? (1=Y/2=N)");
        int endgame = scanner.nextInt();
        
        
        if (endgame == 2)
        {
            System.out.println("Thanks!");
        }
        

       else if (endgame == 1)
       {
        System.out.println("Choose from the following:");
        System.out.println("1. Change color");
        System.out.println("2. Move horizontally");
        System.out.println("3. Move vertically");
        System.out.println("");
        System.out.println("Enter selection:");
        
        int selection2 = scanner.nextInt();
        
        if (selection2 == 1)
        {
            System.out.println("Valid colors are red, yellow, blue, green,magenta and black");
            System.out.println();
            System.out.println("Change color to:");
            String color = scanner.next();
            finitial.changeInitialColor(color);
            
        }
        
        else if (selection2 == 2)
        {
            System.out.println("Change position to:");
            int distance = scanner.nextInt();
            finitial.moveInitialHorizontal(distance);
            
        }
        
        else if (selection2 == 3)
        {
            System.out.println("Change position to:");
            int distance = scanner.nextInt();
            finitial.moveInitialVertical(distance);
            
        }
        
        else if (selection2 > 3)
        {
            System.out.println ("Error: not an option");
        }
        }
        
    }
}
