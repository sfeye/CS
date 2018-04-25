import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
/**
 * mp02.SamuelFeye
 * Samuel Feye
 * Revised 2017.02.01
 * CS 150 - Introduction to Computing
 * 
 */
public class Account
{
   private Date dateOpened;
   
   public Account ()
   {
       this.dateOpened = dateOpened;
   }

   public final Date getDateOpened ()
   {
       return dateOpened;
    }
  
   @Override
   public String toString ()
   {
       String formattedDate = "";
       DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
       formattedDate = df.format(getDateOpened());
       return formattedDate;
    }
    
  
}
