import java.util.Date;

/**
 * Samuel Feye
 * Socratis
 * CS150
 * 02-10-2017
 */
public class UniversityMember
{
    private String first;
    private String last;
    private Date dateCreated;

    public UniversityMember(String first, String last, Date dateCreated)
    {
        setFirst(first);
        setLast(last);
        setDateCreated(dateCreated);
    }

    ///getters
    public final String getFirst     ()  {return first;}
    public final String getLast      ()  {return last;}
    public final String getName      ()  {return last + ", " + first;}
    public final Date getDateCreated ()  {return dateCreated;}

    //setters
    public final void setFirst (String first) {this.first = first;}
    public final void setLast  (String last)  {this.last = last;}
    public final void setName  (String first, String last)  
    {  
        this.first = first;
        this.last = last; 
    }
    public final void setDateCreated (Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }
    
    @Override
    public String toString ()
    {
        //returns the name and the date of the created object
        return getName() + dateCreated;
    }
    
}
