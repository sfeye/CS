
/**
 * File: mp01.SamuelFeye
 * Name: Samuel Feye
 * Revised:  21.01.2017
 * Course: CS150 - Intro to Computing II
 * Desc: allows you to add or subtract angle and convert 
 *       fractional angles to DMS
 */
public class Angle
{
    private final int MINUTES_PER_DEGREE = 60;
    private final int SECONDS_PER_MINUTE = 60;
    private final int SECONDS_PER_DEGREE = 3600;
    private final char DEGREE_SYMBOL = '\u00BA';

    private int degrees;
    private int minutes;
    private double seconds;

    /**default ctor*/
    public Angle ()
    {
        this(0, 0, 0.0);
    }

    /**conveniece ctor for degrees that are fractions */  
    public Angle (double fractionalDegrees)
    {
        //creates a double variable mins
        //to hold the decimal places after doing math on degrees
        double mins = (fractionalDegrees - Math.floor(fractionalDegrees)) * MINUTES_PER_DEGREE;
        //seconds is already a double variable
        seconds = (mins - Math.floor(mins)) * SECONDS_PER_MINUTE;
        //this creates temporary variables to convert the double variables,
        //fractional degrees and mins, to integers and both get rounded down to 0
        int tmp = (int) fractionalDegrees;
        int i = (int) mins;
        //this allows us also to assign those values to int variables,
        //degrees and minutes.
        degrees = tmp;
        minutes = i;
    }

    /**designated ctor, requires input of deg min sec */  
    public Angle (int degrees, int minutes, double seconds)
    {
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    
    //general getters
    public int getDegrees ()
    {
        return degrees;
    }

    public int getMinutes ()
    {
        return minutes;
    }

    public double getSeconds ()
    {
        seconds = Math.round(seconds * 10);
        seconds = seconds / 10;
        return seconds;
    }
    
    
    //takes DMS and converts them to fracti-
    //onal degrees and returns the fraction
    public double getFractionalAngle ()
    {
        double fractionalDegrees;
        double mins;
        double degs;
        mins = minutes + (seconds/SECONDS_PER_MINUTE);
        degs = degrees + (mins/MINUTES_PER_DEGREE);

        fractionalDegrees = degs; 
        return fractionalDegrees;
    }
    

    //general setters
    public void setDegrees (int degrees)
    {
        this.degrees = degrees;
    }

    public void setMinutes (int minutes)
    {
        this.minutes = minutes;
    }

    public void setSeconds (double seconds)
    {
        this.seconds = seconds;
    }

    
    public void setAngle (int degrees, int minutes, double seconds)
    {
        //sets new DMS values to the angle
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    
    public void setFractionalAngle (double fractionalDegrees)
    {
        //sets and converts a new fractional angle to DMS
        double mins = (fractionalDegrees - Math.floor(fractionalDegrees)) * MINUTES_PER_DEGREE;
        seconds = (mins - Math.floor(mins)) * SECONDS_PER_MINUTE;
        int tmp = (int) fractionalDegrees;
        int i = (int) mins;
        degrees = tmp;
        minutes = i;
    }

    public Angle addAngle (Angle other)
    {
        //adds current DMS to DMS of angle "other"
        Angle sum = new Angle (degrees + other.degrees, minutes + other.minutes, seconds + other.seconds);
        return sum;
    }

    public Angle subtractAngle (Angle other)
    {
        //subtracts current DMS to DMS of angle "other"
        Angle difference = new Angle (degrees - other.degrees, minutes - other.minutes, seconds - other.seconds);
        return difference;
    }

    public String toString ()
    {
        //to make positive mins and secs
        if(minutes < 0 || seconds < 0)
        {
            minutes = Math.abs(minutes);
            seconds = Math.abs(seconds);
        }
        
        //carries the seconds over to minutes
        if (seconds >= SECONDS_PER_MINUTE)
        {
            seconds = seconds - SECONDS_PER_MINUTE;
            ++minutes;
        }
        
        //carries the minutes over to degrees
        if (minutes >= MINUTES_PER_DEGREE)
        {
            minutes = minutes - MINUTES_PER_DEGREE;
            ++degrees;
        }

        //returns in DMS format
        return degrees + String.valueOf(DEGREE_SYMBOL) + "  " + minutes + "'" + " " + String.format("%.1f", seconds) + '"';
    }
}
