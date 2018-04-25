import java.util.Scanner;
import java.io.File;
/**
 * Sam Feye
 * Mrs. Tetzner
 * CS140- 001
 * 11-30-2016
 */
public class Main
{

    public static void main (String [] args)
    {

        Worker[] workers = new Worker[50];
        int count = loadArray(workers);

        Scanner scanner = new Scanner(System.in);
        while (true)
        {

            System.out.println("Choose from the following:");
            System.out.println("\tA. Add employee");
            System.out.println("\tB. Remove employee");
            System.out.println("\tC. Change employee hours");
            System.out.println("\tD. Print enployee payroll report");
            System.out.println("\tE. Sort array");
            System.out.println("\tF. Exit");

            System.out.print("Enter selection: ");

            String choice = scanner.next().toLowerCase();

            switch (choice)
            {
                case "a":
                count = addEmployee (workers, count);
                break;

                case "b":
                count = removeEmployee (workers, count);
                break;

                case "c":
                changeEmployeeHours(workers, count);
                break;

                case "d":
                printPayrollReport(workers, count);
                break;

                case "e":
                sortArray(workers, count);
                break;

                case "f":
                System.exit(0);
                break;
            }
        }
    }

    public static int loadArray (Worker [] workers)
    {
        int count = 0;

        try (Scanner scanner = new Scanner(new File("employees.txt")))
        {
            while (scanner.hasNext())
            {
                String name = scanner.next();
                double hours = scanner.nextDouble();
                double pay = scanner.nextDouble();

                if (count < workers.length)

                    workers[count++] = new Worker (name, hours, pay);

            }
        }

        catch (Exception e)
        {
            System.exit(0);
        }
        return count;
    }

    public static int addEmployee (Worker[] workers, int count)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many hours did they work?");
        String name = scanner.next();

        System.out.println("What is their pay per hour?");
        double pay = scanner.nextDouble();

        System.out.println("how many hours did they work?");
        double hours = scanner.nextDouble();

        if (count < workers.length)
            workers[count++] = new Worker (name, hours, pay);

        return count;
    }

    public static void changeEmployeeHours (Worker [] workers, int count)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the employees name: ");
        String name = scanner.next();

        boolean found = false;

        for (int i = 0; i < count; i++)
        {
            Worker worker = workers[1];

            if (worker.getLastName().equals(name))
            {
                System.out.println("Change the number of hours worked from" + worker.getNumHours() + "to: ");
                double hours = scanner.nextDouble();

                worker.setNumHours (hours);

                found = true;

            }

        }

        if (found)
            System.out.println("Employee not found");

    }

    public static int removeEmployee(Worker [] workers, int count)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the employees name: ");
        String name = scanner.next();

        boolean found = false;
        for (int i = 0; i < count; i++)
        {
            Worker worker = workers[i];

            if (worker.getLastName().equals(name))
            {
                for (int j = i + 1; j < 5; j++)
                {
                    workers[i] = workers[j];
                }
            }

            workers[count--] = null;

            found = true;
        }

        if (found)
            System.out.println("Employee not found");

        return count;
    }

    public static void printPayrollReport(Worker [] workers, int count)
    {
        System.out.printf("%-15s %-10s %-10s %-10s %-10s %n", "Name", "Hours", "Pay/Hours", "OT PAY", "Total Pay");

        for(int i = 0; i < count; i++)
        {
            Worker worker = workers[i];

            System.out.printf("%-15s %-8.2f %-10.2f %-10.2f %-10.2f %n", worker.getLastName(), worker.getNumHours(), worker.getPayPerHour(), worker.overTimePay(), worker.totalPay());

        }
    }

    
    public static void sortArray (Worker [] workers, int count)
    {
       for (int i = 0; i < count; i++)
        {

            int index = i;
            
            for (int j = (i +1); j < count; j++)
            {
                Worker w1 = workers [index];
                Worker w2 = workers[j];

                if (w2.getLastName().compareTo(w1.getLastName()) < 0)
                { 
                    index = j;
                }
            }

            Worker w = workers[index];
            workers[index] = workers[i];
            workers[i] = w;

        }

    }
}
