
public class CartItem
{
    // instance variables - replace the example below with your own
    private String item;
    private double price;
    private int quantity;

    public CartItem(String item, double price, int qty)
    {
        this.item = item;
        this.price = price;
        quantity = qty;
    }
        
    public String getItem()
    {
        return item;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setPrice( double price)
    {
        this.price = price;
    }
    
    public void setQuantity(int qty)
    {
       quantity = qty;
    }
    
    public void displayCartItem()
    {
        System.out.printf("%-20s %4d  %10.2f %10.2f \n", item, quantity, price, price * quantity);
    }
}
