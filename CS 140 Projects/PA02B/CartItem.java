
public class CartItem
{
    private String item;
    private int quantity;
    private double price;
    
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
    
    public void setPrice(double price)
    {
        price = price;
    }
    
    public void setQuantity(int qty)
    {
        quantity = qty;
    }
    
    public void displayCartItem()
    {
        double totalPrice;
        int qty;
        qty = quantity;
        totalPrice = (price * qty);
        System.out.printf("%-10s %-10s %-10s %-10s\n", item, quantity, price, totalPrice );
    }
}
