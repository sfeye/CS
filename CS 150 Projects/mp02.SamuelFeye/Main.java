import java.util.Date;
import java.util.Calendar;
/**
 * mp02.SamuelFeye
 * Samuel Feye
 * Revised 2017.02.01
 * CS 150 - Introduction to Computing
 * 
 * Main class tests adding and returning customers/accounts
 */
public class Main
{
    public static void main (String [] args)
    {
        Customer customer1 = new Customer ("Adam", "Apple");
        Customer customer2 = new Customer ("Beatrice", "Bagel");
        Customer customer3 = new Customer ("Chris", "Cucumber");

        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();

        CheckingAccount ca1 = new CheckingAccount(10100, customer1);
        CheckingAccount ca2 = new CheckingAccount(10101, customer2);
        CheckingAccount ca3 = new CheckingAccount(10102, customer3);

        Bank bank = new Bank();
        
        System.out.println(bank.getCustomerCount());

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        bank.addCustomer(customer3);
        
        System.out.println(bank.getCustomerCount());

        bank.openAccount(account1);
        bank.openAccount(account2);
        bank.openAccount(account3);

        bank.customerList();
        //bank.accountList();

        System.out.println(bank.getCustomerAtIndex(1));
        System.out.println();

        //System.out.println(bank.getAccountAtIndex(2));
        //System.out.println(bank.customerList());
        //System.out.println(bank.accountList());

    }
}
