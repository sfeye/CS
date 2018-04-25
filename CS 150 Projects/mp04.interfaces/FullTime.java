
/**
 * Write a description of class FullTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FullTime extends Employee
{
    public FullTime(String first, String last, double annualSalary)
    {
        super(first, last, annualSalary);
    }
    
    @Override
    public String toString ()
    {
        return last + ", " + first;
    }
}
