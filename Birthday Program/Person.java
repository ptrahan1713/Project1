import java.util.Random;

/**
 * This program creates a Person for the Birthday Probability program.
 * It randomly generates its birthday.
 * 
 * @author Patrick Trahan
 */
public class Person
{
    //global variables
    Random rand;
    private int day;
    private int month;
    
    /**
     * Creates the Person object.
     */
    public Person()
    {
        rand = new Random();
        
        //randomly generates the birth month
        month = rand.nextInt(12) + 1;
        
        //randomly generates the birthday
        day = rand.nextInt(31) + 1;
    }
    
    /**
     * Gets the day.
     * @return the day for the Person.
     */
    public int getDay()
    {
        return day;
    }
    
    /**
     * Gets the month.
     * @return the month for the Person.
     */
    public int getMonth()
    {
        return month;
    }
}
