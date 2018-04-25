import java.util.Date;
import java.util.ArrayList;

/**
 * Samuel Feye
 * Socratis
 * CS150
 * 02-10-2017
 */
public class Student extends UniversityMember
{
    private ArrayList <String> coursesTaken = new ArrayList<>();

    public Student (String first, String last, Date dateEnrolled)
    {
        super(first, last, dateEnrolled);
    }

    public final ArrayList <String> getCoursesTaken () { return coursesTaken; }

    public final void addCourse (String course)        { coursesTaken.add(course); }

    @Override
    public String toString ()
    {
        //returns the formatted strings
        String str = "";
        str = "Student: " + getName()  + "\n";
        str += "Date Enrolled: " + getDateCreated() + "\n";
        str += "Courses Taken: " + "(" + coursesTaken.size() + ")" + "\n";
        
        for(String course : coursesTaken)
        {
            str += course + "\n";
        }
        str += "\n";
        return str;
    }
}
