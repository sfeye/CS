

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CustomerTest
{
    Customer c;
    
    @Test
    public void getterShouldReturnCompositeName() {
        assertEquals( "Name should be Doe, John:\n", "Doe, John", c.getName() );
    }
    
    @Test
    public void descriptorShouldFormatNameWithLabel() {
        assertEquals( "String should return: Name: Doe, John:\n", "Name: Doe, John", c.toString() );
    }
    
    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
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
        c = new Customer("John", "Doe");
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
