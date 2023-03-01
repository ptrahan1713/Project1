package probandstattester;

/**
 * This class runs all of the classes in the Probability and Statistics library.
 * 
 * @author Patrick Trahan
 */
public class Run
{
    //global Object variable
    private SetCalculator set = new SetCalculator();
    private Permutation perm = new Permutation();
    private MeanMedianMode calc = new MeanMedianMode();
    private Combination comb = new Combination();
    private Factorial fact = new Factorial();
    private BinomialDistribution binomial = new BinomialDistribution();
    
    //sets the values of the arrays for the union and intersection
    private Integer[] first = {1, 3, 5, 7, 9};
    private Integer[] second = {1, 2, 3, 4, 6, 8, 10};
    private Integer[] universal = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    
    //sets the value for the mean median mode array
    private int[] myArray = {1, 2, 3, 4, 5, 6, 6};
    
    /**
     * This is the backbone for the Probability and Statistics library. It will run every single 
     * method and outputs the values. 
     */
    public void run()
    {
        //calls the method from the union and intersection program
        set.startUp(first, second, universal);
        
        printSeparator();
        
        //calls the method to run the mean median mode program
        calc.solverCalculator(myArray);
        
        printSeparator();
        
        //calls the method to solve the factorial of the given number
        fact.run(17);
        
        printSeparator();
        
        //calls the method to solve the permutation with the given numbers
        perm.run(10, 15);
        
        printSeparator();
        
        //calls the method to solve the combination with the given numbers
        comb.run(15, 10);
        
        printSeparator();
        
        //calls the method to solve the binomial distribution with the given numbers
        binomial.run(.50, 10, 2);
        
        printSeparator();
    }
    
    /**
     * Prints a separator for organizing the outputs of the library.
     */
    public void printSeparator()
    {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - -\n");
    }
    
}
