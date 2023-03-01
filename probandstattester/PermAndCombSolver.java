package probandstattester;

import java.util.Scanner;

/**
 * This program runs the Permutation and Combination. It asks the user from the inputs.
 * 
 * @author Patrick Trahan
 */
public class PermAndCombSolver
{
    //global variables
    private int n;
    private int r;
    private String pOrC;
    private Permutation perm;
    private Combination comb;
    Scanner sncr;
    
    /**
     * This will call the correct methods to run the Permutation and Combination 
     * solvers.
     */
    public void run()
    {
        askUserIntegers();
        
        permOrComb();
    }
    
    /**
     * This method uses a Scanner to ask the user what numbers that they want.
     */
    public void askUserIntegers()
    {
        sncr = new Scanner(System.in);
        
        System.out.print("What do you want \"n\" to be: ");
        
        n = sncr.nextInt();
        
        System.out.print("\nWhat do you want \"r\" to be: ");
        
        r = sncr.nextInt();
    }
    
    /**
     * This method uses a Scanner to ask the user if they want to use permutation
     * or combination.
     */
    public void permOrComb()
    {
        System.out.println("Do you want to do Permutation or Combination?");
        System.out.print("Type (P/C): ");
        
        pOrC = sncr.nextLine();
        
        if(pOrC.equals("P"))
        {
            perm = new Permutation();
            
            perm.permutation(n, r);
        }
        else if(pOrC.equals("C"))
        {
            comb = new Combination();
            
            comb.combination(n, r);
        }
        else
        {
            System.out.println("Not a valid input");
        }
    }
    
}
