import java.util.ArrayList;
/**
 * Write a description of class ShoppingCart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShoppingCart
{
    private ArrayList<CartItem> cart;
    private String name;
    private int qty;
    private double price;
    String item;

    public ShoppingCart ()
    {
        cart = new ArrayList<>();
    }

    public void putInCart(CartItem item)
    {
        cart.add(item);
    }

    public void putInCart(String name, double price, int qty)
    {
        CartItem tmp = new CartItem (item, price, qty);
        cart.add(tmp);
    }

    public CartItem getCartItem(int index)
    {
        String item;
        while (index < cart.size())
        {
            CartItem item = cart.get(index);
        }
        return item;
    }

    public void removeFromCart(int index)
    {   
        if (index >= 0 && index < cart.size())
        {
            cart.remove(index);
        }
    }

    public int numItemsInCart()
    {
        int qty = 0;

        for (CartItem item : cart)
        {
            qty += item.getPrice();
        }

        return qty;
    }

    public double costOfCart()
    {
        double cost = 0;

        for (CartItem item : cart)
        {
            cost += item.getPrice();
        }

        return price;
    }

    public void displayCart()
    {
        for (CartItem item : cart)
        {
            item.displayCartItem();
        }
    }

}
