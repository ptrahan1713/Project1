
import java.util.Scanner;

/**
 * This program calls the group program to create a group of people. From there 
 * you calculate the probability that any 2 people share the same birthday.
 * 
 * @author Patrick Trahan
 */
public class BirthdayProbability
{
    private GroupCreator group;
    private int loop;
    private int count;
    private int groupSize;
    private Person[] groupPerson;
    private int sameBirthday;
    private double birthdayPercentage;
    private Scanner scnr;
    
    /**
     * This method runs the program for the user. 
     */
    public void run()
    {
        //initialize count to 1
        count = 1;
        
        //calls askRun to see how many times they want to run the simulation
        loop = askRun();
        
        //asks the user what they want the size of the group to be
        groupSize = askGroupSize();
        
        //loops till count is larger than loop
        while(count <= loop)
        {
            //creates a GroupCreator object 
            group = new GroupCreator();
        
            //calls the groupCreate method 
            groupPerson = group.groupCreate(groupSize);
        
            //adds up the amount of times there is a same birthday in the group
            sameBirthday = sameBirthday + check();
            
            //increment count
            count++;
        }
        
        calculatePercentage();
        
        printResults();
    }
    
    /**
     * Calculates the percentage of same birthdays.
     */
    public void calculatePercentage()
    {
        birthdayPercentage = (((double)sameBirthday) / ((double)loop) * 100);
    }
    
    /**
     * This method checks to see if two people in the group have the same birthday.
     * 
     * @return 1 if they do and 0 if not.
     */
    public int check()
    {
        //temp index variable
        int index;
        
        //loops through the size of the groupPerson
        for(int i = 0; i < groupPerson.length; i++)
        {
            //set index to equal the value of i
            index = i;
            
            //set a temp array to be groupPerson with the value at position i
            //removed from the array
            Person[] temp = removePerson(groupPerson, i);
            
            //loops till index is greater than the size of temp
            while(index < temp.length)
            {
                //if the month of the person at position i in groupPerson
                //equals the month of the person at position index in temp
                if(groupPerson[i].getMonth() == temp[index].getMonth())
                {
                    //if the day of the person at position i in groupPerson
                    //equals the day of the person at position index in temp
                    if(groupPerson[i].getDay() == temp[index].getDay())
                    {
                        //returns 1 to show there was a pair
                        return 1;
                    }
                }
                //increments index
                index++;
            }
        }
        //returns 0 to show there was no pair
        return 0;
    }
    
    /**
     * This method removes an person from the array at the given index.
     * 
     * @param userGroup is the array that you want to remove from.
     * @param index is the index that you want to remove.
     * @return returns the array with the index removed.
     */
    public Person[] removePerson(Person[] userGroup, int index)
    {
        //creates a new person array with a size of userGroup - 1
        Person[] temp = new Person[userGroup.length - 1];
        
        //loops through the length of userGroup
        for(int i = 0, j = 0; i < userGroup.length; i++)
        {
            //if the value of i does not equal the value of index
            if(i != index)
            {
                //set the value into temp
                temp[j] = userGroup[i];
                
                //increment j
                j++;
            }
        }
        //return the new array
        return temp;
    }
    
    /**
     * Asks the user how many runs they want to do.
     * 
     * @return the int value of the amount of loops.
     */
    public int askRun()
    {
        //create the scanner object
        scnr = new Scanner(System.in);
        
        //asks the user the question
        System.out.print("\nHow many runs do you want to have: ");
        
        //returns the input that the user inputted
        return scnr.nextInt();
    }
    
    /**
     * Asks the user what do they want the size to be.
     * 
     * @return the int value of the size. 
     */
    public int askGroupSize()
    {
        //asks the user the question
        System.out.print("\nWhat do you want the size of the group to be: ");
        
        //returns the input that the user inputted
        return scnr.nextInt();
    }
    
    public void printResults()
    {
        System.out.println("\nFrom completing " + loop +" loops of program");
        System.out.println("and a group size of " + groupSize);
        System.out.println("The amount of two people having the same birthday is " + sameBirthday);
        System.out.printf("The Percentage of that is %.2f%%\n", birthdayPercentage);
    }
}
