
/**
 * Write a description of class PayWithWage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PayWithWage implements PayPolicy
{
    private double hourlyRate;
    private double hoursPerWeek;
    private double regularHours;
    private double overtimeHours;
    
    public PayWithWage (double hourlyRate, double hoursPerWeek)
    {
        setHourlyRate(hourlyRate);
        setHoursPerWeek(hoursPerWeek);
    }
    
    public final double getHourlyRate () {return hourlyRate;}
    public final double getHoursPerWeek () {return hoursPerWeek;}
    public final double getRegularHours () {return regularHours;}
    public final double getOvertimeHours () {return overtimeHours;}
    
    public final void setHourlyRate(double hourlyRate) {this.hourlyRate = hourlyRate;}
    public final void setHoursPerWeek(double hoursPerWeek) {this.hoursPerWeek = hoursPerWeek;}
    
    public double regularPay ()
    {
        return 0.0;
    }
    
    public double overtimePay()
    {
        return 0.0;
    }
    
    @Override
    public double pay ()
    {
        return ( regularPay() + overtimePay() );
    }
}
