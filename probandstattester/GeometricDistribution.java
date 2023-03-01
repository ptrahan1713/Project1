package probandstattester;

/**
 * This program solves the Geometric Distribution with the given values.
 * 
 * @author Patrick Trahan
 */
public class GeometricDistribution
{
    private double geometric;
    
    /**
     * This method is the backbone for the Geometric Distribution program.
     * 
     * @param prob is the probability of success.
     * @param trials is the number trials done.
     */
    public void run(double prob, int trials)
    {
        solveGeometric(prob, trials);
        
        printGeometricDistribution();
    }
    
    /**
     * This method solves the Geometric Distribution with the given values.
     * 
     * @param prob is the probability of success.
     * @param trials is the number trials done.
     */
    public void solveGeometric(double prob, int trials)
    {
        geometric = Math.pow((1 - prob), (trials - 1)) * prob;
    }
    
    /**
     * This method prints the Geometric Distribution.
     */
    public void printGeometricDistribution()
    {
        System.out.println("The Geometric Distribution is " + geometric);
    }
}
