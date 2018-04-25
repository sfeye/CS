import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;

/**
 * The test class InstructorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InstructorTest
{
    Instructor me;
    Date dh;
    
    @Test
    public void shouldInitializeInstructorObject() {
        assertTrue( "dateCreated should be assigned to parameter:\n", dh == me.getDateCreated() );
        assertNotNull( "coursesTaught should not be null: \n", me.getCoursesTaught() );
    }
    
    @Test
    public void shouldReturnCoursesTaught() {
        ArrayList<String> ct = me.getCoursesTaught();
        assertEquals("should return coursesTaught of size 2", 2, ct.size() );
    }
    
    @Test
    public void shouldAddACourse() {
        me.addCourse("CS240");
        
        assertEquals("coursesTaught should be of size 3", 3, me.getCoursesTaught().size() );
    }
    
    @Test
    public void shouldReturnFormattedDescription() {
        String str = "";
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        
        str += String.format("%15s %s", "Instructor:", me.getName() );
        str += String.format("%n%15s %s", "doh:", df.format( me.getDateCreated() ) );
        str += String.format( "%n%15s (%d)%n", "Courses taught:", me.getCoursesTaught().size() );
        
        for ( String course : me.getCoursesTaught() ) {
            str += "\t" + course + "\n";
        }
        
        assertEquals( "Insructor object not formatted properly:\n", str, me.toString() );
    }
    
    /**
     * Default constructor for test class InstructorTest
     */
    public InstructorTest()
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
        dh = new Date();
        me = new Instructor("John", "Doe", dh);
        
        me.addCourse("CS140-Introduction to Computing I");
        me.addCourse("CS150-Introduction to Computing II");
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
