/*
* Name: Samuel C Feye
* Class: CS140-001
* Fall 2016
* Assignment: Programming Assignment 01C
* Date: 09/07/2016
*/
public class Main
{
    public static void main(String [] arggs)
    {
       System.out.println("Programmed by Lori Tetzner");
       System.out.println();
       System.out.println();
       DiscountCalculator firstItem = new DiscountCalculator();
       System.out.println("Constructor 1: ");
       firstItem.printReceipt();
       
       DiscountCalculator secondItem = new DiscountCalculator("Pens");
       System.out.println("Constructor 2: ");
       secondItem.printReceipt();
       
       System.out.println("FirstItem - Receipt 1");
       firstItem.setItemName("Frying Pan");
       firstItem.setCostPerItem(19.99);
       firstItem.setNumPurchased(12);
       firstItem.printReceipt();
       
       System.out.println("FirstItem - Receipt 2");
       firstItem.setNumPurchased(60);
       firstItem.printReceipt();
       
       System.out.println("SecondItem - Receipt 1");
       secondItem.setItemName("Pens");
       secondItem.setCostPerItem(.28);
       secondItem.setNumPurchased(30);
       secondItem.printReceipt();
       
       System.out.println("The percent discount for item 2 is: " 
                            + secondItem.getPercentDiscount() + "%");
       
       System.out.println("SecondItem - Receipt 2");                     
       secondItem.setCostPerItem(.32);
       secondItem.setNumPurchased(8);
       secondItem.printReceipt();
       
     
       
    }
}