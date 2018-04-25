
/**
 * mp02.SamuelFeye
 * Samuel Feye
 * Revised 2017.02.01
 * CS 150 - Introduction to Computing
 * 
 */
public class Customer
{
    private String first;
    private String last;
    
    public Customer (String first, String last) 
    {
        setFirst(first);
        setLast(last);
    }
    
    //getter
    public final String getFirst() { return first;               }
    public final String getLast()  { return last;                }
    public final String getName()  { return "Name: " + last + ", " + first; }
    
    //setters
    public final void setFirst(String first)  { this.first = first;                   }
    public final void setLast(String last)    { this.last = last;                     }
    
    //descriptor
    @Override
    public String toString() {
        return "Name: " + last + ", " + first;
    }
}
