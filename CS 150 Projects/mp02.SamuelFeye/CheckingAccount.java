    
/**
 * mp02.SamuelFeye
 * Samuel Feye
 * Revised 2017.02.01
 * CS 150 - Introduction to Computing
 * 
 */
public class CheckingAccount extends Account
{
    private int accountNumber;
    private Customer owner;
    
    public CheckingAccount (int accountNumber, Customer owner)
    {
        setAccountNumber(accountNumber);
        setOwner(owner);
    }
    
    //getters
    public final int getAccountNumber () {return accountNumber;}
    public final Customer getOwner ()    {return owner;}
    
    //setters
    private void setAccountNumber (int accountNumber) {this.accountNumber = accountNumber;}
    private void setOwner (Customer owner)            {this.owner = owner;}
    
    //descriptor
    @Override
    public String toString ()
    {
        return accountNumber + ", " + getOwner();
    }
}
