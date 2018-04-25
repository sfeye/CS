
public class Shopper
{
    // instance variables - replace the example below with your own
    public Person person;
    public ShoppingCart cart;
    
    public Shopper(String name, String streetAddress, String city, String state, String zipCode, String phoneNumber)
    {
        person = new Person(name, streetAddress, city, state, zipCode, phoneNumber);
        cart = new ShoppingCart();
    }
 
    public Shopper()
    {
        person = new Person();
        cart = new ShoppingCart();
        
    }
    
}

