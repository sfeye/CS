import java.util.ArrayList;
import java.util.Date;
/**
 * Samuel Feye
 * Socratis
 * CS150
 * 02-10-2017
 */
public class Instructor extends UniversityMember
{
    private ArrayList<String> coursesTaught = new ArrayList<>();
    
    public Instructor (String first, String last, Date dateHired)
    {
        super(first, last, dateHired);
    }
    
    public final ArrayList<String> getCoursesTaught () {return coursesTaught;}
    
    public final void addCourse (String course)        { coursesTaught.add(course);}
    
    @Override
    public String toString () 
    {
        //returns the formatted string and all of the 
        //courses in a for loop
        String str = "";
        str = "Instructor: "  + super.getName()  + "\n";
        str += "doh: " + super.getDateCreated() + "\n";
        str += "Courses taught: " + "(" + coursesTaught.size() + ")" + "\n";
        
        for(String course : coursesTaught)
        {
            str += course + "\n";
        }
        str += "\n";
        return str;
    }
}
