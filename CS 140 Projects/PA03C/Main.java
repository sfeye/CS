import java.util.Scanner;
import java.io.File;
/**
 * Sam Feye
 * Professor Tetzner
 * CS 140 
 * Nov 6, 2016
 */
public class Main
{
    public static final int MAXSIZE = 100;
    public static Scanner scanner = new Scanner(System.in);

    public static void main (String [] args)
    {

        int [] value = new int[MAXSIZE];
        int count = loadArray(value);

        while (true)
        {
            System.out.println("Choose from the following:");

            System.out.println("\tA. Reload array with new numbers");
            System.out.println("\tB. Average numbers in array");
            System.out.println("\tC. Find maximum number in array");
            System.out.println("\tD. Cont positive numbers in array");
            System.out.println("\tE. Sort array");
            System.out.println("\tF. Print array");
            System.out.println("\tG. Exit");

            System.out.print("Enter selection: ");

            String choice = scanner.next().toLowerCase();

            switch (choice)
            {
                case "a":
                count = loadArray(value);
                break;

                case "b":
                double average = averageArray(value, count);
                System.out.printf("The average of the %d numbers in the array is %.2f%n", count, average);
                break;

                case "c":
                int largestNumber = findLargest(value, count);
                System.out.println("The largest number in the array is " + largestNumber);
                break;

                case "d":
                int positiveNumbers = countPositives(value, count);
                System.out.println("The number of positive numbers in the array is " + positiveNumbers);
                break;

                case "e":
                sortArray(value, count);
                break;

                case "f":
                printArray(value, count);
                break;

                case "g":
                System.exit(0);
                break;
            }
        }

    }

    public static int loadArray (int[] array)
    {
        System.out.print("Enter the file that you would like to read data from: ");
        String fileName = scanner.next();

        int count = 0;

        try{
            Scanner scan = new Scanner(new File(fileName));

            while (scan.hasNext())
            {

                if (count == MAXSIZE)
                    break;

                array[count++] = scan.nextInt();

            }

        }
        catch (Exception e)
        {
            System.exit(0);
        }

        return count;
    }

    public static void printArray (int[] array, int count)
    {
        for (int i = 0; i < count; i++)
        {
            System.out.print("\t" + array [i]);

            if ((i +1) % 5 == 0)
                System.out.print("\n");

        }

        System.out.println("");
    }

    public static double averageArray (int[] array, int count)
    {

        double total = 0.0;
        for (int i = 1; i < count; i++)
        {
            total += array[i];
        }

        return total/count;

    }

    public static int findLargest (int[] array, int count)
    {

        int max = array [0];
        for (int i = 1; i < count; i++)
        {
            int num = array[i];
            if (num > max)
            { max = num;}
        }
        return max;

    }

    public static int countPositives (int[] array, int count)
    {

        int positiveNumbers = 0;
        for (int i = 1; i < count; i++)
        {
            int num = array[i];
            if (num > 0)
            {  positiveNumbers++;}
        }
        return positiveNumbers;

    }

    public static void sortArray (int[] array, int count)
    {
        for (int i = 0; i < count; i++)
        {

            int index = i;
            
            for (int j = (i +1); j < count; j++)
            {
                int num2 = array[i];

                if ( array[j] < array[index])
                { 
                    index = j;
                }
            }

            int num = array[index];
            array[index] = array[i];
            array[i] = num;

        }

        printArray(array, count);
    }
}

