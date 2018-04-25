import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.text.DateFormat;
/**
 * The test class BankTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BankTest
{
    Bank b;
    
    @Test
    public void ctorShouldCreateEmptyArrays() {
        assertEquals( "Customer count should be 0:\n", 0, b.getCustomerCount() );
        assertEquals( "Account count should be 0:\n", 0, b.getAccountCount() );
        
        assertNull("No customer object should exist:\n", b.getCustomerAtIndex(0) );
        assertNull("No account object should exist:\n", b.getAccountAtIndex(0) );
    }
    
    @Test
    public void shouldReturnCustomerAtIndex0() {
        b.addCustomer(new Customer("Adam","Apple"));
        
        assertEquals("Should return customer \"Apple, Adam\":\n", "Name: Apple, Adam", b.getCustomerAtIndex(0).toString() );
    }
    
    @Test
    public void shouldReturnAccountAtIndex0() {
        b.openAccount( new CheckingAccount(10100, new Customer("Adam","Apple") ) );
        
        CheckingAccount ca = (CheckingAccount)b.getAccountAtIndex(0);
        
        assertEquals( "Should return account 10100:\n", 10100, ca.getAccountNumber() );
        assertEquals( "Should return Apple, Adam:\n", "Apple, Adam", ca.getOwner().getName() );
    }
    
    @Test
    public void shouldAddCustomerToTheEndOfTheArray() {
        b.addCustomer( new Customer("Adam", "Apple") );
        b.addCustomer( new Customer("Beatrice", "Bagel") );
        
        //assertEquals("Bagel, Beatrice should be the last customer:\n", "Bagel, Beatrice", b.getCustomerAtIndex(1).getName() );
    }
    
    @Test
    public void shouldAddAccountAndCustomerToTheEndOfTheArray() {
        b.openAccount( new CheckingAccount( 10100, new Customer("Adam", "Apple") ) );
        b.openAccount( new CheckingAccount( 10101, new Customer("Beatrice", "Bagel") ) );
        
        CheckingAccount ca = (CheckingAccount)b.getAccountAtIndex(1);
        
        assertEquals("Account 10101 should be the last account:\n", 10101, ca.getAccountNumber() );
        assertEquals("Bagel, Beatrice should be the last customer:\n", "Bagel, Beatrice", b.getCustomerAtIndex(1).getName() );
    }
    
    @Test
    public void shouldListAllCustomers() {
        b.openAccount( new CheckingAccount( 10100, new Customer("Adam", "Apple") ) );
        b.openAccount( new CheckingAccount( 10101, new Customer("Beatrice", "Bagel") ) );
        
        String customerListFormatted = "Name: Apple, Adam" + "\n" + "Name: Bagel, Beatrice" + "\n";
        
        assertEquals( "Customer list not formatted properly:\n", customerListFormatted, b.customerList() );
    }
    
    @Test
    public void shoudlListAllAccounts() {
        b.openAccount( new CheckingAccount( 10100, new Customer("Adam", "Apple") ) );
        b.openAccount( new CheckingAccount( 10101, new Customer("Beatrice", "Bagel") ) );
        
        String accountListFormatted = b.getAccountAtIndex(0).toString() + "\n" + 
                                      b.getAccountAtIndex(1).toString() + "\n";
                                      
        assertEquals( "Account list is not formatted properly:\n", accountListFormatted, b.accountList() );                             
    }
    
    @Test
    public void shouldReturnProperlyFormattedBankRecord() {
        b.openAccount( new CheckingAccount( 10100, new Customer("Adam", "Apple") ) );
        b.openAccount( new CheckingAccount( 10101, new Customer("Beatrice", "Bagel") ) );
        
        String bankRecordFormatted = "Customers(" + b.getCustomerCount() + ")\n" +
                                     b.customerList() + "\n" + 
                                     "Accounts(" + b.getAccountCount() + ")\n" +
                                     b.accountList().toString();
                                      
        assertEquals( "Back record is not formatted properly:\n", bankRecordFormatted, b.toString() );                             
    }
    
    /**
     * Default constructor for test class BankTest
     */
    public BankTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        b = new Bank();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
