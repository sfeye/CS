
/**
 * Abstract class Employee - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Employee implements Comparable<Employee>
{
    private String first;
    private String last;
    protected PayPolicy payPolicy;
    
    protected Employee (String first, String last, PayPolicy payPolicy)
    {
        
    }
    
    public final String getFirst () {return first;}
    public final String getLast () {return last;}
    public final String getName () {return last + ", " + last;}
    
    public final PayPolicy getPayPolicy () {return payPolicy;}
    
    public final void setFirst (String first) {this.first = first;}
    public final void setLast (String last) {this.last = last;}
    public final void setName (String first, String last) {this.first = first; 
                                                            this.last = last;}
    
    public final void setPayPolicy (PayPolicy payPolicy ) {this.payPolicy = payPolicy;}
    
    public double payCheck ()
    {
        return 0.0;
    }
    
    @Override
    public int compareTo (Employee o)
    {
        return 1;
    }
    
    @Override 
    public String toString ()
    {
        String str = "";
        return str;
    }
}
