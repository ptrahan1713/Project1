package probandstattester;

/**
 * This program takes in an array and will find the mean, median, mode, variance, and
 * standard deviation. 
 * 
 * @author Patrick Trahan
 */
public class MeanMedianMode
{
    private int[] meanArray;
    private int[] medianArray;
    private int[] modeArray;
    private int[] varianceArray;
    private int[] sDArray;
    
    private double[] calculatedVariance; 
    
    private int middle;
    private double sum;
    private int[] count;
    private double squaredValue;
    private int maxPosition;
    private boolean modeValidate;
    
    private int medianValue;
    private int evenMedianValue;
    private double average;
    private double variance;
    private double standardDeviation;
    
    /**
     * This method is to call of the different methods to find the values
     * 
     * @param userArray is the array that the user made
     */
    public void solverCalculator(int[] userArray)
    {
        //prints the user array
        printArray(userArray);
        
        System.out.println("When you sort the array");
        //prints the sorted array
        printArray(sortedArray(userArray));
        
        //calls the method to find the mean 
        mean(userArray);
        
        //calls the method to find the median
        median(userArray);
        
        //calls the method to find the mode
        mode(userArray);
        
        //calls the method to find the variance
        variance(userArray);
        
        //calls the method to find the standard deviation
        standardDeviation(userArray);
    }
    
    /**
     * This method sorts the array in ascending order
     * 
     * @param userArray is the array that the user created
     * @return the sorted array 
     */
    public int[] sortedArray(int[] userArray)
    {
        //a temp value for storing the values 
        int temp;
        
        //this will set i to the value that you want to make is the smallest
        for(int i = 0; i < userArray.length; i++)
        {
            //this will let you check to see if i is the smallest
            for(int j = i + 1; j < userArray.length; j++)
            {
                //checks to see if the first position is greater than the second
                if(userArray[i] > userArray[j])
                {
                    //this part is to flip the two values 
                    temp = userArray[i];
                    userArray[i] = userArray[j];
                    userArray[j] = temp;
                }
            }
        }
        //returns the sorted array now
        return userArray;
    }
    
    /**
     * This method is to find the mean of the array
     * 
     * @param userArray is the array that the user created
     */
    public void mean(int[] userArray)
    {
        //this for loop is to add the sum of all of the elements of the array
        for (int i = 0; i < userArray.length; i++)
        {
            sum = sum + userArray[i];
        }
       
        //average is found by dividing the sum by the length of the array
        average = sum / userArray.length;
        
        //calls the method to print the average for the viewer
        printAverage();
    }
    
    /**
     * Prints the average(mean) of the array
     */
    public void printAverage()
    {
        System.out.printf("The mean(average) is: %.4f \n\n", average);
    }
    
    /**
     * This method is to find the median of the array
     * 
     * @param userArray is the array that the user created
     */
    public void median(int[] userArray)
    {
        //makes sure the array is sorted
        medianArray = sortedArray(userArray);
        
        //takes the length of the array and halves it to sort the middle position
        middle = medianArray.length / 2;
        
        //sorts the element at position of the middle value of the array
        medianValue = medianArray[middle];
        
        //to see whether or not the array's length is even or odd
        if(medianArray.length % 2 == 0)
        {
            //the even case
            
            //since it's even means there is another median value compared to the middle one
            evenMedianValue = medianArray[middle - 1];
            
            //calls the method to print the two median values for the array
            printEvenMedian();
        }
        else
        {
            //the odd case
            
            //if odd then there is nothing else to do so just print the median value
            printOddMedian();
        }
    }
    
    /**
     * Prints the median of the odd case
     */
    public void printOddMedian()
    {
        System.out.println("The median is: " + medianValue + "\n");
    }
    
    /**
     * Prints the median of the even case.
     */
    public void printEvenMedian()
    {
        System.out.println("The median is: " + evenMedianValue + ", " + medianValue + "\n");
    }
    
    /**
     * This method finds the mode of the array.
     * 
     * @param userArray 
     */
    public void mode(int[] userArray)
    {
        //sorts the passed in array and stores it into the modeArray
        modeArray = sortedArray(userArray);
        
        //creates a new array count with the length of modeArray
        count = new int[modeArray.length];
        
        //initialize the count array with elements of 1
        for(int i = 0; i < count.length; i++)
        {
            count[i] = 1;
        }
        
        //loops through the length of the modeArray
        for(int i = 0; i < modeArray.length; i++)
        {
            //loops throgh the length of the modeArray plus i
            for(int j = 1 + i; j < modeArray.length; j++)
            {
                //if the modeArray at parameter i is equal to the modeArray at
                //parameter j
                if(modeArray[i] == modeArray[j])
                {
                    //then increment count at position i plus 1
                    count[i]++;
                }
            }
        }
        
        //validates if the mode is the mode
        validateMode(count);
    }
    
    /**
     * Validates the mode of the array.
     * 
     * @param countArray
     */
    public void validateMode(int[] countArray)
    {
        //store maxElement as the value of the first position of count
        int maxElement = count[0];
        
        //loops through the length of the countArray
        for(int i = 0; i < countArray.length; i++)
        {
            //if element at position i of the countArray is greater than the maxElement 
            if(countArray[i] > maxElement)
            {
                //then store the element into the maxElement
                maxElement = countArray[i];
            }
        }
        
        //if maxElement is 1
        if(maxElement == 1)
        {
            //set the modeValidate to false
            modeValidate = false;
        }
        else
        {
            //calls the locator method 
            maxPosition = locator(countArray, maxElement);
        }
        
        //calls the checkMode method to validate the mode
        modeValidate = checkMode(count, maxPosition, maxElement);
        
        //print the mode
        printMode(modeValidate);
    }
    
    /**
     * This method checks the mode to make sure the mode is actually the mode.
     * 
     * @param array is the passed in array
     * @param maxPosition is the position of the mode in the array
     * @param maxElement is the element of the mode in the array
     * 
     * @return true or false
     */
    public boolean checkMode(int[] array, int maxPosition, int maxElement)
    {
        //loops through the length of the array from maxPosition + 1
        for(int i = maxPosition + 1; i < array.length; i++)
        {
            //if the element at position i in the array is equal to the maxElement
            if(array[i] == maxElement)
            {
                //returns False
                return false;
            }
        }
        //return True otherwise
        return true;
    }
    
    /**
     * This method locates the position of the mode of the array.
     * 
     * @param array is the passed in array
     * @param maxElement is the element that you think is the mode
     * 
     * @return the position of the maxElement in the array
     */
    public int locator(int[] array, int maxElement)
    {
        //temp value
        int temp = 0;
        
        //while temp is less than the length of the array
        while(temp < array.length)
        {
            //if maxElement is equal to the array at 
            if(maxElement == array[temp])
            {
                return temp;
            }
            temp++;
        }
        return -1;
    }
    
    /**
     * This method prints what the mode is for the even array.
     * 
     * @param validater verifies the given mode to make sure its valid or not.
     */
    public void printMode(boolean validater)
    {
        if(validater)
        {
            System.out.println("The mode is: " + modeArray[maxPosition]);
        }
        else
        {
            System.out.println("There is no such value for the mode");
        }
        
        System.out.println();
    }
    
    /**
     * This method finds the variance of the array
     * 
     * @param userArray the array the user created
     */
    public void variance(int[] userArray)
    {
        //initizes the variance array to be the userArray
        varianceArray = userArray;
        
        //creates a new array with a size of variance array
        calculatedVariance = new double[varianceArray.length];
        
        //loops through the length of calculatedVariance
        for(int i = 0; i < calculatedVariance.length; i++)
        {
            //initizes all its elements to 0
            calculatedVariance[i] = 0;
        }
        
        //get each value's deviation from the mean
        for(int i = 0; i < varianceArray.length; i++)
        {
            calculatedVariance[i] = varianceArray[i] - average;
        }
        
        //square each of the values of the array
        for(int i = 0; i < calculatedVariance.length; i++)
        {
            calculatedVariance[i] = calculatedVariance[i] * calculatedVariance[i];
        }
        
        //add up all of the squared values
        for(int i = 0; i < calculatedVariance.length; i++)
        {
            squaredValue = squaredValue + calculatedVariance[i];
        }
        
        //divide the squared values by the length of the array
        variance = squaredValue / varianceArray.length;
        
        printVariance();
    }
    
    /**
     * Prints the variance of the array
     */
    public void printVariance()
    {
        System.out.printf("The variance is: %.4f \n\n", variance);
    }
    
    /**
     * This method finds the standard deviation of the array
     * 
     * @param userArray 
     */
    public void standardDeviation(int[] userArray)
    {
        sDArray = userArray;
        
        standardDeviation = Math.sqrt(variance);
        
        printStandardDeviation();
    }
    
    /**
     * Prints the standard deviation of the array
     */
    public void printStandardDeviation()
    {
        System.out.printf("The standard deviation is: %.4f \n", standardDeviation);
    }
    
    /**
     * Prints the original array that the user created
     * 
     * @param userArray is the array the user created
     */
    public void printArray(int[] userArray)
    {
        System.out.println("The array is:");
        
        for(int i = 0; i < userArray.length; i++)
        {
            System.out.print(userArray[i] + " ");
        }
        
        System.out.println("\n");
    }
}
