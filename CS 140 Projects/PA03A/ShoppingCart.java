import java.util.List;
import java.util.ArrayList;

public class ShoppingCart
{
    // instance variables - replace the example below with your own
    private ArrayList<CartItem> cart;


    public ShoppingCart()
    {
       cart = new ArrayList<>();
    }


    public void putInCart(CartItem item)
    {
        cart.add(item);
    }
    
    public void putInCart(String name, double price, int qty)
    {
        CartItem tmp = new CartItem(name, price, qty);
        cart.add(tmp);
    }
    
    public CartItem getCartItem(int value)
    {
        if (value >= 0 && value < cart.size()) 
            return(cart.get(value));
        else
        {
            CartItem error = new CartItem("",-1,-1);
            System.out.println("The item you are trying to get doesn't exist");
            return(error);
        }
    }
    
    public void removeFromCart(int value)
    {
        if (value >= 0 && value < cart.size()) 
            cart.remove(value);
        else
            System.out.println("The item you are trying to remove doesn't exist");    
    }
    
    public void displayCart()
    {
        CartItem tmp;
        for (int i = 0; i < cart.size(); ++i)
        {
            tmp = cart.get(i);
            tmp.displayCartItem();
        }
    }
    
    public int numItemsInCart()
    {
        CartItem tmp;
        int total = 0;
        for (int i = 0; i < cart.size(); ++i)
        {
            tmp = cart.get(i);
            total += tmp.getQuantity();
        }
        return(total);
    }
    
    public int size()
    {
        return (cart.size());
    }
    
    public double costOfCart()
    {
        CartItem tmp;
        double total = 0;
        for (int i = 0; i < cart.size(); ++i)
        {
            tmp = cart.get(i);
            total += tmp.getQuantity() * tmp.getPrice();
        }
        return(total);        
    
    }   
}
