
/**
 * Write a description of class Shopper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shopper
{
    public Person person;
    public ShoppingCart cart;
    
    
    public Shopper (String name, String streetAddress, String city, 
                    String state, String zipcode, String phoneNumber)
    
    {
        person = new Person (name, streetAddress, city, state, zipcode, phoneNumber);
        cart = new ShoppingCart();
       
    }
}
