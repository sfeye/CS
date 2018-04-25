import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.text.DateFormat;
/**
 * The test class CheckingAccountTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CheckingAccountTest
{
    CheckingAccount ca;
    
    @Test
    public void ctorInitializesAccount() {
        assertEquals("Account number should be 10100:\n", 10100, ca.getAccountNumber() );
        assertEquals("Owner should be Apple, Adam:\n", "Name: Apple, Adam", ca.getOwner().toString() );
    }
    
    @Test
    public void descriptorShouldFormatAccount() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
        
        String properFormat = "[" + ca.getAccountNumber() + "], ";
        properFormat += "Opened: " + df.format( ca.getDateOpened() );
        properFormat += ", " + ca.getOwner().toString();
        
        assertEquals( "Account not formatted properly:\n", properFormat, ca.toString() );
    }
    
    /**
     * Default constructor for test class CheckingAccountTest
     */
    public CheckingAccountTest()
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
        ca = new CheckingAccount( 10100, new Customer("Adam", "Apple") );
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
