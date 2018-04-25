
/**
 *Sam Feye
 *Tetzner CS140-001
 *Fall 2016
 *09/08/2016
 */

public class DiscountCalculator
{
    //fields
    private String itemName;
    private double costPerItem;
    private int numPurchased;
    private double percentDiscount;
    private double salesTax;
    private double totalCost;
    
    //constructor 1
    public DiscountCalculator ()
    {
        itemName = "XXXXX";
        costPerItem = 0.0;
        numPurchased = 0;
        percentDiscount = 0.0;
        salesTax = 7.5;
        totalCost = 0.0;
    }
    
    //constructor 2
    public DiscountCalculator (String newItemName)
    {
        costPerItem = 0.0;
        numPurchased = 0;
        percentDiscount = 0.0;
        salesTax = 7.5;
        totalCost = 0.0;
    }
    
    //method to set cost
    public void setCostPerItem (double cost)
    {
        costPerItem = cost;
    }
    
    //method to set number purchased
    public void setNumPurchased (int num)
    {
        numPurchased = num;
    }
    
    //method to set the name of item
    public void setItemName (String name)
    {
        itemName = name;
    }
    
    //returns the percent discounted based on number purchaed
    public double getPercentDiscount ()
    {
        return percentDiscount;
    }
   
    //Determines the percent dicount based on number purchased plus the outputs
    public void printReceipt ()
    {
        if (numPurchased < 10)
        {
            percentDiscount = 0.0;
        }
        
        if (numPurchased >= 10)
        {
            if(numPurchased < 25)
            {
            percentDiscount = 15;
        }
    }
        
        if (numPurchased >= 25)
        {
        if(numPurchased < 50)
            {
            percentDiscount = 25;
        }
    }
        
        if (numPurchased >= 50)
        {
            percentDiscount = 35;
        }
        
        //math equations used to determine total cost after sales tax and discount
        this.totalCost = ((costPerItem * numPurchased) * (percentDiscount * .01));
        totalCost = ((costPerItem * numPurchased) - this.totalCost) + (((costPerItem * numPurchased)-this.totalCost) * 0.075);
        
        //system printed output
        System.out.println("Receipt");
        System.out.println("**********************");
        System.out.println("Item: " + itemName);
        System.out.println("CostPerItem: " + costPerItem);
        System.out.println("Quantity: " + numPurchased);
        System.out.println("Percent Discount (%) : " + percentDiscount);
        System.out.println("Sales Tax Rate: " + salesTax);
        System.out.println("**********************");
        System.out.println("Total Cost: " + totalCost);
        System.out.println("**********************");
    } 
    
}
