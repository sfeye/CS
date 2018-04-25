import java.util.Scanner;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner(System.in);

        //code to test scanner
        System.out.println("\nCode to test CartItem Class");
        String itemName;
        String clearOut;
        double costPerItem;
        int qty;

        CartItem firstItem;
        CartItem secondItem;
        CartItem thirdItem;

        //User enters 1st item
        System.out.println("\nUser enters first Item");
        System.out.print("Enter candy you are purchasing: ");
        itemName = keyboard.nextLine();
        System.out.print("Enter quantity: ");
        qty = keyboard.nextInt();
        System.out.print("Enter cost: ");
        costPerItem = keyboard.nextDouble();
        clearOut = keyboard.nextLine();

        //Create Items
        System.out.println("\nCreate Items - can't see on output");
        firstItem = new CartItem(itemName, costPerItem, qty);
        secondItem = new CartItem("Eggs", 1.29, 3);
        thirdItem = new CartItem("Doritos", 4.59, 2);

        //display items
        System.out.println("\nDisplay Items");
        firstItem.displayCartItem();
        secondItem.displayCartItem();
        thirdItem.displayCartItem();

        //change price and quantity of users candy
        System.out.println("\nChange Price and Quantity of user's candy");
        System.out.printf("How many packs of %s: ", itemName);
        qty = keyboard.nextInt();
        System.out.printf("What is the new price of %s: ", itemName);
        costPerItem = keyboard.nextDouble();

        firstItem.setPrice(costPerItem);
        firstItem.setQuantity(qty);

        //display items again
        System.out.println("\nDisplay Items again");
        firstItem.displayCartItem();
        secondItem.displayCartItem();
        thirdItem.displayCartItem();

        //notice you can also print an item this way
        //by getting each item and then printing it here in main
        //this allows you to format the output how ever you want
        //when using a class
        System.out.println("\nNotice you can also print an item this way");
        System.out.println("by getting each item and then printing it here in main");
        System.out.println("this allows you to format the output how ever you want");
        System.out.println("when using a class.");
        itemName = secondItem.getItem();
        costPerItem = secondItem.getPrice();
        qty = secondItem.getQuantity();

        System.out.printf("Item: %s, Quantity: %d, Price: %.2f \n", itemName, qty, costPerItem);

        //notice - there is no way to change the item name - so the only way to give an item a
        //name is using the constructor - why do you think it is set up this way?

        
        
        
        
        
        
        //code to test ShoppingCart class
        System.out.println("\n\nCode to Test ShoppingCart Class");
        System.out.println("\nCreate 2 shopping Carts - can't see it on output");
        ShoppingCart firstCart = new ShoppingCart();
        ShoppingCart secondCart = new ShoppingCart();

        //you can put items in the cart
        System.out.println("\nYou can put items in the cart - 2 different ways - check main to see how");
        secondCart.putInCart(firstItem);
        firstCart.putInCart(secondItem);
        secondCart.putInCart(thirdItem);

        //You can also put item in cart this way - putincart must be overloaded
        secondCart.putInCart("Mountain Dew", 1.29, 4);
        firstCart.putInCart("Pretzel Chips", 3.29, 2);

        //you can display the carts
        System.out.println("You can display the carts");
        System.out.println("Cart 1 : ");
        firstCart.displayCart();
        System.out.println();
        System.out.println("Cart 2 : ");
        secondCart.displayCart();
        System.out.println();

        //can also determine the cost of the cart and how many items are in it
        System.out.println("\nCan also determine the cost of the cart and how many items are in it");
        System.out.printf("The number of items in shopping Cart 2 is: %d\n", secondCart.numItemsInCart());
        System.out.printf("The items in shopping cart 2 add up to : %.2f\n", secondCart.costOfCart());

        //You can also take something out of the cart (based on the index of where it is)
        System.out.println("\nYou can also take something out of the cart (based on the index of where it is)");
        System.out.println("Removing second item from class 2");
        secondCart.removeFromCart(1);
        secondCart.displayCart();

        //You can get information about 1 item in the cart if you know the index
        System.out.println("You can get information about 1 item in the cart if you know the index");
        System.out.println("Want to see what is at index 0: ");
        CartItem tmp;
        tmp = secondCart.getCartItem(0);
        tmp.displayCartItem();

        //interestingly, here is another way to do it - no need for another Cart Item
        System.out.println("\nInterestingly, here is another way to do it");
        secondCart.getCartItem(0).displayCartItem();

        System.out.println("\nWhat happens when you try to remove something from the cart in an index that isn't there?");
        secondCart.removeFromCart(2);

        tmp = secondCart.getCartItem(-2);

        System.out.println("\nand notice what got returned");
        tmp.displayCartItem();

    }

}
