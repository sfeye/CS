import java.util.Date;
/**
 * mp02.SamuelFeye
 * Samuel Feye
 * Revised 2017.02.01
 * CS 150 - Introduction to Computing
 * 
 **/
public class Bank
{
    private static final int MAX_CUSTOMERS = 100;
    private static final int MAX_ACCOUNTS = 200;

    private Customer[] customers = new Customer [MAX_CUSTOMERS];
    private int customerCount = 0;
    private Account[] accounts = new Account[MAX_ACCOUNTS];
    private int accountCount = 0;

    public Bank ()
    {
        
    }

    //getters
    public final int getCustomerCount ()            {return customerCount;}
    public final int getAccountCount ()             {return accountCount;}

    public final Customer getCustomerAtIndex (int index) 
    {
        if (index <= getCustomerCount())
        {    
            return customers[index];
        }
        return new Customer("Last", "First");
    }

    public final Account getAccountAtIndex (int index)  
    {
        if (index <= getAccountCount())
        {
            Account account = accounts [index];
            return account;
        }
        return new Account();
    }

    public final void addCustomer (Customer o)
    {
            o = customers [customerCount];
            customerCount++;
    }

    public final void openAccount (Account o)
    {
        if (accountCount < MAX_ACCOUNTS)
        {
            accounts [accountCount++] = o;
            if (o instanceof CheckingAccount)
            {
                CheckingAccount ca = (CheckingAccount) o;
                addCustomer(ca.getOwner());
            }
        }
    }

    public String customerList ()
    {   String nameOfCustomers = ""; 
        //for (int i = 0; i <= customerCount; i++)

        //{
             nameOfCustomers = customers[0].getName();
        //}
        return nameOfCustomers;
    }

    public String accountList ()
    {
        String nameOfAccounts = "";
        for (int i = 0; i <= accountCount; i++)

        {
            Account a = accounts[i];
            if (a instanceof CheckingAccount)
              {
                  CheckingAccount ca = (CheckingAccount) a;
                  nameOfAccounts += ca.getAccountNumber() + "Opened: " +
                                    ca.getDateOpened() + ", Name: " + ca.getOwner() 
                                    + "\n";
                }
        }
        return nameOfAccounts;
    }

    @Override
    public String toString ()
    {
        String printedBankRecord = "Customers: " + customerCount + "\n"
                                    + customerList() + "\n"
                                    + "Accounts: " + accountCount + "\n"
                                    + accountList() + "\n";
        return printedBankRecord;
    }
}

