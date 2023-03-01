/**
 * This program creates the array of Person. 
 * 
 * @author Patrick Trahan
 */
public class GroupCreator
{
    private int groupSize;
    private Person[] group;
    
    /**
     * This method takes the userGroupSize and calls a method to create
     * the array and then return the array.
     * 
     * @param userGroupSize is the size of the array.
     * @return the array of Person.
     */
    public Person[] groupCreate(int userGroupSize)
    {
        //stores the value of userGroupSize into groupSize
        groupSize = userGroupSize;
        
        //calls the method to create the array
        groupCreation();
        
        //returns the array
        return group;
    }
    
    /**
     * This method creates the array and returns it.
     * 
     * @return the array of Person objects. 
     */
    public Person[] groupCreation()
    {
        //creates the array with size of groupSize
        group = new Person[groupSize];
        
        //loops to groupSize
        for(int i = 0; i < groupSize; i++)
        {
            //stores the Person object to the array at position i
            group[i] = new Person();
        }
        //returns the array 
        return group;
    }
}
