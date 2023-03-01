package problem2.pkg20;

import java.util.Random;

/**
 * This program is to find the probability of the choices you could make in the 
 * game show. This is for problem 2.20 in the textbook. Each run has two possibilities,
 * one where you set the door you choose (which is door 2) or the door of your choice 
 * is randomly generated. There are a total of 4 runs 2 of them have whether you change 
 * the door halfway through or stick to the door you originally chose. 
 * 
 * @author Patrick Trahan
 */
public class Problem220
{

    private String door1;
    private String door2;
    private String door3;
    private Random rand;
    private int prize;
    private int winRate;
    private String choice;
    private Object yourChoice;
    private Object winningDoor;
    private boolean ifWon;
    private double winPercentage;
    private int option;

    /**
     * This method calls the game show 10,000 times.
     */
    public void run()
    {
        //prints the intro to the gameShow
        printGame();
        
        //this for loop is for the 4 possibilities that can happen
        for(int i = 0; i < 4; i++)
        {
            //resets the winRate
            winRate = 0;
            
            //the if-else statement is whether or not your choice is random or not
            if(i < 2)
            {
                //option 1 means not random
                option = 1;
            }
            else
            {
                //option 2 means random
                option = 2;
            }
            
            //tell the user which possibility they are at
            callRun(i);
            
            //This for loop is for simulating the game
            for (int j = 0; j < 10000; j++)
            {
                //calls the method to run the gameShow
                gameShow(i);
            }
            
            //prints the winRate and percentage
            calculateWinRate();
        }
    }
    
    /**
     * This method calls the correct print method for which run you are on.
     * 
     * @param run is the variable for which run you are on.
     */
    public void callRun(int run)
    {
        if(run == 0)
        {
            printFirstRun();
        }
        else if(run == 1)
        {
            printSecondRun();
        }
        else if(run == 2)
        {
            printThirdRun();
        }
        else
        {
            printFourthRun();
        }
    }
    
    /**
     * This method is the backbone to the game. It calls all of the methods to operate
     * the gameShow.
     * @param numberRun tells the computer which run they are on.
     */
    public void gameShow(int numberRun)
    {
        //method to setup the doors
        setup();
        
        //sets your choice for which door you think is correct
        yourChoice();

        //simulates the results of your choice
        runGame(numberRun);
    }

    /**
     * This method sets up where the brand new car is for the game show.
     */
    public void setup()
    {
        rand = new Random();

        //sets which door is going to have the car
        prize = rand.nextInt(3);

        //depending on what prize is will set what the doors are
        if(prize == 0)
        {
            door1 = "Brand new car!!!";
            winningDoor = door1;
            door2 = "just a goat";
            door3 = "just a goat";
        }
        else if(prize == 1)
        {
            door2 = "Brand new car!!!";
            winningDoor = door2;
            door1 = "just a goat";
            door3 = "just a goat";
        }
        else
        {
            door3 = "Brand new car!!!";
            winningDoor = door3;
            door1 = "just a goat";
            door2 = "just a goat";
        }
    }

    /**
     * This method sets which door you choose.
     */
    public void yourChoice()
    {
        //first part is to have the same door for the run
        if (option == 1)
        {
            yourChoice = door2;
        }
        //second part is to have it randomly generated
        else
        {
            int temp = rand.nextInt(3);
            
            if(temp == 0)
            {
                yourChoice = door1;
            }
            else if(temp == 1)
            {
                yourChoice = door2;
            }
            else
            {
                yourChoice = door3;
            }
        }
    }

    /**
     * This method checks to see if you were correct in your choice.
     * 
     * @param numberRun tells the computer which run they are on.
     */
    public void runGame(int numberRun)
    {
        //this if statement for both run 2 and run 4
        if(numberRun % 2 != 0)
        {
            //this method means you are changing the door of your choice
            revealOtherDoor();
        }
        
        //checks to see if you won the game
        if (yourChoice.equals(winningDoor))
        {
            //if so then increment winRate by 1
            winRate++;
        }
    }
    
    /**
     * This method is for when the game show reveals one of the doors. The door
     * they reveal is one that is not a winning door. And you change your door to 
     * the other option.
     */
    public void revealOtherDoor()
    {
        //for when the door you originally chose was door 1
        if(yourChoice.equals(door1))
        {
            if(door1.equals(winningDoor))
            {
                //assume door 2 was revealed
                yourChoice = door3;
            }
            //change to door 2 since door 3 was revealed 
            if(door2.equals(winningDoor))
            {
                yourChoice = door2;
            }
            //change to door 3 since door 2 was revealed
            if(door3.equals(winningDoor))
            {
                yourChoice = door3;
            }
        }
        //for when the door you originally chose was door 2
        else if(yourChoice.equals(door2))
        {
            //change to door 1 since door 3 was revealed
            if(door1.equals(winningDoor))
            {
                yourChoice = door1;
            }
            if(door2.equals(winningDoor))
            {
                //assume door 3 was revealed
                yourChoice = door1;
            }
            //change to door 3 since door 1 was revealed
            if(door3.equals(winningDoor))
            {
                yourChoice = door3;
            }
        }
        //for when the door you originally chose was door 3
        else
        {
            //change to door 1 since door 2 was revealed
            if(door1.equals(winningDoor))
            {
                yourChoice = door1;
            }
            //change to door 2 since door 1 was revealed
            if(door2.equals(winningDoor))
            {
                yourChoice = door2;
            }
            if(door3.equals(winningDoor))
            {
                //assume door 1 was revealed
                yourChoice = door2;
            }
        }
    }
    
    /**
     * This method calculates your win percentage of the 10,000 runs.
     */
    public void calculateWinRate()
    {
        System.out.println("Win rate is: " + winRate);

        winPercentage = ((double) winRate / 10000) * 100;

        System.out.printf("The win Percentage is: %.2f%% %n", winPercentage);
    }

    /**
     * This method prints out the intro to the game.
     */
    public void printGame()
    {
        System.out.println("Welcome to the game show!\n");

        System.out.println("There will be 3 doors and behind one of the doors is a");
        System.out.println("BRAND NEW CAR!!!!!!\n");
    }
    
    /**
     * Prints the situation of run 1.
     */
    public void printFirstRun()
    {
        System.out.println("\nExperiment 1:");
        System.out.println("From only choosing door 2 and you DO NOT switch");
        System.out.println("doors when revealed the other one. Your result would");
        System.out.println("look like the following:\n");
    }
    
    /**
     * Prints the situation of run 2.
     */
    public void printSecondRun()
    {
        System.out.println("\n\nExperiment 2:");
        System.out.println("From only choosing door 2 and you DO switch");
        System.out.println("Doors when revealed the other one. Your result would");
        System.out.println("look like the following:\n");
    }
    
    /**
     * Prints the situation of run 3.
     */
    public void printThirdRun()
    {
        System.out.println("\n\nExperiment 3:");
        System.out.println("From randomly selecting the door of your choice");
        System.out.println("and you DO NOT switch doors when revealed the other one.");
        System.out.println("Your result would look like the following:\n");
    }
    
    /**
     * Prints the situation of run 4.
     */
    public void printFourthRun()
    {
        System.out.println("\n\nExperiment 4:");
        System.out.println("From randomly selecting the door of your choice");
        System.out.println("and you DO switch doors when revealed the other one.");
        System.out.println("Your result would look like the following:\n");
    }
}
