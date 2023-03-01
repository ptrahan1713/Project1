package probandstattester;

import java.math.BigInteger;

/**
 * This program solves the given inputs with permutation.
 * 
 * @author Patrick Trahan
 */
public class Permutation
{
    private Factorial factorial = new Factorial();
    private BigInteger permutation;
    private BigInteger top;
    private BigInteger bottom;
    
    /**
     * This method runs the Permutation class using the template design pattern.
     * 
     * @param n is the first element
     * @param r is the second element
     */
    public void run(int n, int r)
    {
        permutation(n, r);
        
        printPermutation(n, r, permutation);
    }
    
    /**
     * This method is the backbone of the combination method.
     * 
     * @param n is a parameter
     * @param r is a parameter
     */
    public void permutation(int n, int r)
    {
        top = factorial.factorialCalculator(n);
        
        bottom = factorial.factorialCalculator(n - r);
        
        permutation = top.divide(bottom);
    }
    
    /**
     * Prints the permutation of the numbers.
     * 
     * @param n is a parameter
     * @param r is a parameter.
     * @param permutation is the value for it
     */
    public void printPermutation(int n, int r, BigInteger permutation)
    {
        System.out.println("The Permutation of n = " + n + " and r = " + r);
        System.out.println("The Permutation = " + permutation);
    }
}

