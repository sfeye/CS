import java.util.Scanner;
/**
 * Sam Feye
 * Lori Tetzner
 * CS 140-001
 * 10/05/2016
 */
public class Main
{
    public static void main(String [] args)
    {
        System.out.println("Programmed by Sam Feye");
        System.out.println("This program asks the user to enter in all of the ages in the class");
        System.out.println("and then prints the average age, the oldest, and the youngest.");
        
        Scanner scanner = new Scanner (System.in);
        double age;
        System.out.println("");
        System.out.println("Type a negative number to exit.");
        age = 0;
        double sum = 0;
        double num = 0;
        double largest = 0;
        double smallest = 200;
        
        System.out.printf("Enter age: ");
        while ((age = scanner.nextDouble()) >= 0)
        {
            System.out.printf("Enter age: ");
            sum += age;
            num++;
            
            if (largest < age)
            {
                largest = age;
            }
            
            if (smallest > age)
            {
                smallest = age;
            }
        }
        System.out.println("");
        
        if (sum <= 0)
            {
                System.out.println("No ages entered...");
            }
        else
        {
        System.out.println("");
        System.out.println("Class Information");
        System.out.println("********************************************************************");
        System.out.println("Average age: " + (sum/num));
        System.out.println("Oldest age: " + largest);
        System.out.println("Youngest age: " + smallest);
    }
        
        
        
    }
}
