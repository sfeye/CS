
/**
 * Write a description of class Intern here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intern extends Employee
{
    public Intern (String first, String last)
    {
        this.first = first;
        this.last = last;
    }
    
    @Override
    public String toString ()
    {
        return last + ", " + first;
    }
}
