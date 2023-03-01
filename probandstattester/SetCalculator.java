package probandstattester;

/**
 * This program takes in 3 arrays. First and second arrays being arrays that the user created and 
 * are subsets. The third one being the universal set of the array. From those parameters the program
 * will calculate the intersection and union of the two arrays. It will also find the complement of the 
 * first and second array from the universal set. 
 * 
 * @author Patrick Trahan
 */
public class SetCalculator<E>
{

    //List of variables
    private E[] intersectionList;
    private E[] unionList;
    private E[] firstComplement;
    private E[] secondComplement;

    /**
     * This is the run method for the program. It will call of the appropriate
     * methods to solve everything you need.
     *
     * @param firstList
     * @param secondList
     * @param universal
     */
    public void startUp(E[] firstList, E[] secondList, E[] universal)
    {
        //call to print the first list
        printFirstList(firstList);
        
        //call to print the second list
        printSecondList(secondList);
        
        //call to print the universal list
        printUniversal(universal);
        
        //call to find the intersection
        intersection(firstList, secondList);
        
        //call to print the intersection
        printIntersection(intersectionList);
        
        //call to find the union
        union(firstList, secondList);
        
        //call to print the union
        printUnion(unionList);
        
        //call to find the complement of the first array
        firstComplement = complement(firstList, universal);
        
        //call to print the complement of the first array
        printComplement(firstComplement, "first");
        
        //calls to find the complement of the second array
        secondComplement = complement(secondList, universal);
        
        //call to print the complement of the second array
        printComplement(secondComplement, "second");
    }
    
    /**
     * This method will find the intersection from the two arrays.
     * 
     * @param firstList 
     * @param secondList 
     */
    public void intersection(E[] firstList, E[] secondList)
    {
        //loops through the length of the first array
        for (int i = 0; i < firstList.length; i++)
        {
            //loops through the length of the second array
            for (int j = 0; j < secondList.length; j++)
            {
                //if the first array at position i equals the second array at position j
                if (firstList[i] == secondList[j])
                {
                    //then add the element at position i from the first array to the
                    //intersection array with the addElement method
                    intersectionList = addElement(intersectionList, firstList[i]);
                }
            }
        }
    }

    /**
     * This method will find the union of the two given arrays.
     *
     * @param firstList
     * @param secondList
     */
    public void union(E[] firstList, E[] secondList)
    {
        //loops through the length of the first array
        for (int i = 0; i < firstList.length; i++)
        {
            //adds the element at position i from the firstList array into the union
            unionList = addElement(unionList, firstList[i]);
        }
        
        //loops through the length of the second array
        for (int i = 0; i < secondList.length; i++)
        {
            //if the element at position i from the second array is not in the union array
            if(!containsElement(unionList, secondList[i]))
            {
                //then add that element to the union array
                unionList = addElement(unionList, secondList[i]);
            }
        }
    }

    /**
     * This is the method to find the complement of a set with the universal
     * set.
     *
     * @param userList
     * @param universal
     * @return 
     */
    public E[] complement(E[] userList, E[] universal)
    {
        //copies the universal to a temp array
        E[] temp = universal;

        //Loops through the set and removes the elements of it from the temp array
        for (int i = 0; i < userList.length; i++)
        {
            //method to remove the element from the set 
            temp = removeElement(temp, userList[i]);
        }
        
        return temp;
    }
    
    /**
     * This method loops through the userList array and sees if the element is in the array.
     * 
     * @param userList
     * @param element
     * @return 
     */
    public boolean containsElement(E[] userList, E element)
    {
        //loops through the length of the userList array
        for(int i = 0; i < userList.length; i++)
        {
            //if the element at position i from the userList array is equal to the element
            if(userList[i] == element)
            {
                //then return true
                return true;
            }
        }
        //if the element is not in the userList array then return false
        return false;
    }
    
    /**
     * This method adds an element to the userList array.
     * 
     * @param userList
     * @param element
     * @return 
     */
    public E[] addElement(E[] userList, E element)
    {
        //base case
        //if the userList array is null 
        if (userList == null)
        {
            //then create a new Object with a size of 1
            E[] temp = (E[]) new Object[1];
            
            //store the element in the first position of the temp array
            temp[0] = element;
            
            //return the temp array
            return temp;
        }
        
        //create a temp array with a length of 1 + the size of the userList array
        E[] temp = (E[]) new Object[userList.length + 1];
        
        //holds the position of temp
        int tempPosition = 0;

        //loops through the length of the userList array
        for (int i = 0; i < userList.length; i++)
        {
            //store the element at position i from the userList array into the temp array
            //at position tempPosition
            temp[tempPosition] = userList[i];
            
            //increment tempPosition by 1
            tempPosition++;
        }
        
        //add the element at the end of the temp array 
        temp[tempPosition] = element;
        
        //return the temp array
        return temp;
    }

    /**
     * This method lets you remove an element from the array.
     *
     * @param userList
     * @param element
     * @return
     */
    public E[] removeElement(E[] userList, E element)
    {
        //temporarily create an array will one less length of the userList
        E[] temp = (E[]) new Object[userList.length - 1];

        //loops through the length of userList
        for (int i = 0, j = 0; i < userList.length; i++)
        {
            //if userList at position i is not equal to the element 
            if (userList[i] != element)
            {
                //store the value into temp at position j
                temp[j] = userList[i];

                //increment j by one
                j++;
            }
        }

        return temp;
    }

    /**
     * Prints the first list.
     *
     * @param first
     */
    public void printFirstList(E[] first)
    {
        System.out.println("The first list is: ");

        printList(first);
    }

    /**
     * Prints the second list.
     *
     * @param second
     */
    public void printSecondList(E[] second)
    {
        System.out.println("The second list is: ");

        printList(second);
    }

    /**
     * Prints the universal set.
     *
     * @param universalList
     */
    public void printUniversal(E[] universalList)
    {
        System.out.println("The universal list is: ");

        printList(universalList);
    }

    /**
     * Prints the union of the two arrays.
     *
     * @param unionList
     */
    public void printUnion(E[] unionList)
    {
        System.out.println("The union is: ");

        printList(unionList);
    }

    /**
     * Prints the intersection of the two arrays.
     *
     * @param intersectionList
     */
    public void printIntersection(E[] intersectionList)
    {
        System.out.println("The intersection is: ");

        printList(intersectionList);
    }

    /**
     * Prints the complement of the array with the universal array.
     *
     * @param complementList
     * @param nameArray
     */
    public void printComplement(E[] complementList, String nameArray)
    {
        System.out.println("The complement of the " + nameArray + " is: ");

        printList(complementList);
    }

    /**
     * Prints the given array.
     *
     * @param userList
     */
    public void printList(E[] userList)
    {
        for (int i = 0; i < userList.length; i++)
        {
            System.out.print(userList[i] + " ");
        }

        System.out.println("\n");
    }
}
