
/**
 * Write a description of class PayWithSalary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PayWithSalary implements PayPolicy
{
    private double annualSalary;
    
    public PayWithSalary ( double annualSalary)
    {
        setAnnualSalary(annualSalary);
    }
    
    public final double getAnnualSalary () {return annualSalary;}
    public final void setAnnualSalary (double annualSalary) {this.annualSalary = annualSalary;}
    
    @Override
    public double pay()
    {
        return (annualSalary / 52) * 2;
    }
    
    @Override
    public String toString ()
    {
        String str = "";
        return str + pay();
    }
}
