import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Sam Feye
 * Mrs. Tetzner
 * Cs140 
 * 10/26/2016
 */
public class Main
{ 

    public static void main(String [] args) {
        //put the code to declare the Scanner for the file // and test to make sure it opened correctly here
        Scanner fin = null;
        try
        {
            fin = new Scanner (new File ("ShopperFile.txt"));
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Could not find file...");
            System.exit(1);
        }

        Shopper shopper1 = new Shopper();
        loadShopperFromFile(fin, shopper1); 
        System.out.println("First Shopper ****************");
        shopper1.person.printMailingLabel();
        shopper1.cart.displayCart();

        //Repeat the lines above for shopper 2 and shopper 3 }
        Shopper shopper2 = new Shopper(); 
        loadShopperFromFile(fin, shopper2); 
        System.out.println("Second Shopper ****************"); 
        shopper2.person.printMailingLabel(); 
        shopper2.cart.displayCart();

        Shopper shopper3 = new Shopper(); 
        loadShopperFromFile(fin, shopper3);
        System.out.println("Third Shopper ****************"); 
        shopper3.person.printMailingLabel(); 
        shopper3.cart.displayCart();
    }

    public static void loadShopperFromFile(Scanner fin, Shopper shopper)
    {
        String line;
        int pos;
        String name;
        String address;
        String city;
        String state;
        String zipcode;
        String phoneNumber;
        int num;

        line = fin.nextLine();
        pos = line.indexOf(",");
        name = line.substring(0, pos);

        line = line.substring(pos+1);
        pos = line.indexOf(",");
        address = line.substring (0, pos);

        line = line.substring(pos+1);
        pos = line.indexOf(",");
        city = line.substring (0, pos);

        line = line.substring(pos+1);
        pos = line.indexOf(",");
        state = line.substring (0, pos);

        line = line.substring(pos+1);
        pos = line.indexOf(",");
        zipcode = line.substring (0, pos);

        line = line.substring(pos+1);
        phoneNumber = line;

        shopper.person.setName(name);
        shopper.person.setStreetAddress(address);
        shopper.person.setCity(city);
        shopper.person.setState(state);
        shopper.person.setZipCode(zipcode);
        shopper.person.setPhoneNumber(phoneNumber);

        line = fin.nextLine();
        num = Integer.parseInt(line);

        for (int i = 0; i < num; ++i)
        {
            String item;
            double cost;
            int qty;
            String stringcost;
            String stringqty;
            double total;

            line = fin.nextLine();
            pos = line.indexOf(",");
            item = line.substring (0, pos);

            line = line.substring(pos+1);
            pos = line.indexOf(",");
            stringcost = line.substring (0, pos);

            line = line.substring(pos+1);
            stringqty = line;
            cost = Double.parseDouble(stringcost);

            qty = Integer.parseInt(stringqty);

            shopper.cart.putInCart(item, cost, qty);
        }
    }
}
