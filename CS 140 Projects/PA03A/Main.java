
import java.util.Scanner;
public class Main extends ShoppingCart
{
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String [] args)
    {
        Shopper shopper1 = new Shopper("Mickey Mouse", "100 Fantasy Lane", "Orlando","FL","11111","407-111-1111");
        Shopper shopper2 = new Shopper("Minnie Mouse", "105 Fantasy Lane", "Orlando","FL","11111","407-222-2222");

        shopper1.cart.putInCart("Eggs", 3.06, 2);
        shopper1.cart.putInCart("Apples", 0.79, 6);
        shopper1.cart.putInCart("Milk", 3.29, 1);
        shopper1.cart.putInCart("Mountain Dew", 1.59, 2);     
        shopper1.cart.putInCart("M&Ms",1.79, 5);
        shopper1.cart.putInCart("Bananas", 1.89, 3);
        shopper1.cart.putInCart("Bread", 2.19, 2);
        shopper2.cart.putInCart("Eggs", 3.06, 1);
        shopper2.cart.putInCart("Apples", 0.79, 10);
        shopper2.cart.putInCart("Milk", 3.29, 2);
        shopper2.cart.putInCart("Doritos",4.59,3);
        
        System.out.println("**********Shopper 1 Info***********");
        shopper1.person.printMailingLabel();
        shopper1.cart.displayCart();
        System.out.println();
        System.out.println("**********Shopper 2 Info***********");
        shopper2.person.printMailingLabel();
        shopper2.cart.displayCart();

        int selection;
        selection = getValidSelection();
        System.out.println("The valid selection entered is: " + selection);

        System.out.println("\nTesting printCartWithNumbers - passing shopper1 in ****************");
        printCartWithNumbers(shopper1);

        System.out.println("\nTesting removeItemFromCart - passing shopper1 in ****************");
        removeItemFromCart(shopper1);
        System.out.println("Reprinting to make sure it is deleted");
        printCartWithNumbers(shopper1);

        System.out.println("\nTesting enterAndPutNewItemIn - passing shopper1 in ****************");
        enterAndPutItemIn(shopper1);    
        System.out.println("Reprinting to make sure it was added");
        printCartWithNumbers(shopper1);

    } 

    public static int getValidSelection ()
    {
        System.out.println("");
        System.out.println("**********************************");
        System.out.println("Choose from the following: ");
        System.out.println("");
        System.out.println("\t1.\tPrint address of shopper");
        System.out.println("\t2.\tPrint items in cart");
        System.out.println("\t3.\tAdd items");
        System.out.println("\t4.\tRemove items");
        System.out.println("\t5.\tQuit");
        System.out.println("");

        System.out.println("Enter Selection: ");
        int selection = keyboard.nextInt();

        if (selection < 1 || selection > 5)
        {
            System.out.println("Try again...");
            System.out.println("Enter selction: ");
            selection = keyboard.nextInt();
        }
        return selection;

    }

    public static void printCartWithNumbers (Shopper shopper)
    {
        System.out.println("Shopper: " + shopper.person.getName());

        int size = shopper.cart.size();
        int i = 0;
        while ( i <= size)
        {
            System.out.println((i+1) + ".\t");
            ++i;
            shopper.cart.getCartItem(i).displayCartItem();
        }
    }

    public static void removeItemFromCart (Shopper shopper)
    {
        printCartWithNumbers(shopper);
        System.out.println("Which item would you like to remove: ");
        int selection = keyboard.nextInt();
        shopper.cart.removeFromCart(selection);
    }

    public static void enterAndPutItemIn (Shopper shopper)
    {
        System.out.println("Name of item: ");
        String name = keyboard.next();
        System.out.println("Cost per item: ");
        int price = keyboard.nextInt();
        System.out.println("Number of items: ");
        int quantity = keyboard.nextInt();
        shopper.cart.putInCart (name, price, quantity);
    }
}

