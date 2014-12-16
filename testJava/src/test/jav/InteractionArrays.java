package test.jav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InteractionArrays 
{
	public static void main(String[] args)
	{
		Integer [] A1 = {1,2,2,3,4,5,6};
		Integer[] A2 = {2,2,4,3};
		System.out.println(finIntersaction(A1, A2));
	}

	public static List finIntersaction(Integer[] A1, Integer[] A2)
	{

	List Alist = Arrays.asList(A1);
	List interaction = new ArrayList();
	for(int i=0; i< A2.length; i++)
	    {
	        if(Alist.contains(A2[i]))
	        {
	            interaction.add(A2[i]);
	        }
	    }
	    
	    return interaction;
	}


	}
