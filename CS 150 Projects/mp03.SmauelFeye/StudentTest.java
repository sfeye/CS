import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;

/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    Student me;
    Date de;
    
    @Test
    public void shouldInitializeInstructorObject() {
        assertTrue( "dateCreated should be assigned to parameter:\n", de == me.getDateCreated() );
        assertNotNull( "coursesTaken should not be null: \n", me.getCoursesTaken() );
    }
    
    @Test
    public void shouldReturnCoursesTaken() {
        ArrayList<String> ct = me.getCoursesTaken();
        assertEquals("should return coursesTaken of size 2", 2, ct.size() );
    }
    
    @Test
    public void shouldAddACourse() {
        me.addCourse("CS240");
        
        assertEquals("coursesTaken should be of size 3", 3, me.getCoursesTaken().size() );
    }
    
    @Test
    public void shouldReturnFormattedDescription() {
        String str = "";
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        
        str += String.format("%15s %s", "Student:", me.getName() );
        str += String.format("%n%15s %s", "enrolled:", df.format( me.getDateCreated() ) );
        str += String.format( "%n%15s (%d)%n", "Courses taken:", me.getCoursesTaken().size() );
        
        for ( String course : me.getCoursesTaken() ) {
            str += "\t" + course + "\n";
        }
        
        assertEquals( "Student object not formatted properly:\n", str, me.toString() );
    }

    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
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
        de = new Date();
        me = new Student("John", "Doe", de);
        
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
