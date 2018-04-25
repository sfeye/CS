
/**
 * Write a description of class PartTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartTime extends Employee
{
    public PartTime(String first, String last, double hourlyRate, 
                                               double hoursPerWeek)
    {
        super(first, last , hourlyRate, hoursPerWeek);
    }
     
    @Override
    public String toString ()
    {
        return last + ", " + first;
    }
}
