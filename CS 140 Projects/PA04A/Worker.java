
/**
 * Write a description of class Worker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Worker
{
    private String lastName;
    private double payPerHour;
    private double numHours;

    public Worker (String name, double payPerHour, double numHours)
    {
        this.lastName = name;
        this.payPerHour = payPerHour;
        this.numHours = numHours;
        

    }
    public String getLastName()
    {

        return lastName;

    }

    public double getPayPerHour()
    {

        return payPerHour;

    }

    public double getNumHours()
    {

        return numHours;

    }

    public void setPayPerHour(double payPerHour)
    {
        this.payPerHour = payPerHour;
    }
    
    public void setNumHours(double numHours)
    {
        this.numHours = numHours;
    }
    
    public double overTimePay()
    {
        double overTime = 0;
        if (numHours > 40)
        {
            overTime = (numHours - 40.00) * (payPerHour * 1.5);
        }
        
        return overTime;
    }
    
    public double totalPay()
    {
        double total = overTimePay();
        
        
        if ( numHours > 40.00)
        { 
            total += (40.00 * payPerHour);
        }
        else
        {
            total = (numHours  * payPerHour);
        }
        
        return total;
    }
    
    public String toString()
    {

        return lastName + " " + payPerHour + " " + numHours;

    }

}
