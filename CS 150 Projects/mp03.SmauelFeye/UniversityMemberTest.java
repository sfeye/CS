import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.text.DateFormat;

/**
 * The test class UniversityMemberTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UniversityMemberTest
{
    UniversityMember um;
    
    @Test
    public void shouldFullyInitializeObject() {
        assertEquals( "First should be \"John\":\n", "John", um.getFirst() );
        assertEquals( "Last should be \"Doe\":\n", "Doe", um.getLast() );
        assertEquals( "dateCreated should be the current date:\n", new Date(), um.getDateCreated() );
    }
    
    
    @Test
    public void shouldReturnFormattedFullName() {
        assertEquals( "getName() should return \"Doe, John\":\n", "Doe, John", um.getName() );
    }
    
    @Test
    public void shouldNotSetToNewDateInstance() {
        Date dateCreated = new Date();
        um.setDateCreated(dateCreated);
        
        assertTrue("setDateCreated() should set dateCreated to parameter date:\n", um.getDateCreated() == dateCreated);
    }
    
    @Test
    public void shouldReturnFormattedDescription() {
        String formattedString = "";
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String formattedDate = df.format( um.getDateCreated() );
        
        formattedString += "[" + um.getName() + "][" + df.format( um.getDateCreated() ) + "]";
        
        assertEquals( "UniversityMember object not formatted properly:\n", formattedString, um.toString() );
    }
    
    /**
     * Default constructor for test class UniversityMemberTest
     */
    public UniversityMemberTest()
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
        um = new UniversityMember( "John", "Doe", new Date() );
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
