package probandstattester;

import java.math.BigInteger;

/**
 * This program is to calculate the Binomial Distribution will the user inputs.
 * 
 * @author Patrick Trahan
 */
public class BinomialDistribution
{
    //global variables 
    private Combination comb = new Combination();
    private BigInteger number;
    private double combination;
    private double binomialDistribution;
    
    /**
     * This method runs the methods to calculate the Binomial Distribution.
     * 
     * @param probSuccess this is the decimal number of the probability of success.
     * @param trial is the number of trials run.
     * @param success is the number of successes from the trials.
     */
    public void run(double probSuccess, int trial, int success)
    {
        binomialDistribution(probSuccess, trial, success);
        
        printBinomialDistribution();
    }
    
    /**
     * Calculates the Binomial Distribution of the given inputs.
     * 
     * @param probSuccess is the decimal number of the probability of success.
     * @param trial is the number of trials run.
     * @param success is the number of successes from the trials.
     */
    public void binomialDistribution(double probSuccess, int trial, int success)
    {
        number = comb.combination(trial, success);
        
        combination = number.doubleValue();
        
        binomialDistribution = combination * Math.pow(probSuccess, success) * Math.pow((1 - probSuccess), (trial - success));
    }
    
    /**
     * Prints the Binomial Distribution.
     */
    public void printBinomialDistribution()
    {
        System.out.printf("The Binomial Distribution is %.4f %n", binomialDistribution);
    }
}
