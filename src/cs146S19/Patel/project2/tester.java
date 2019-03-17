package cs146S19.Patel.project2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


class tester {
	//tester for brute force used to collect data on time on excel 
	@Test
	void bruteForceTimer() 
	{
		testing_helper th = new testing_helper();
		int i =1;
		while(i<=100)
		{
			float time = th.bruteForceTimer(i);
			System.out.println(time +"   brute force");
			if(i<10)
			{
				i +=1;
			}
			else 
			{
				i +=10;
			}
		}
		
	}
	//tester for kadane used to collect data on time on excel 
	@Test
	void kadaneTimer() 
	{
		testing_helper th = new testing_helper();
		int i =10000;
		while(i<=100000)
		{
			float time = th.kadaneTimer(i);
			System.out.println(time + "   kadane Timer");
			i+= 1000;
		}
		
	}
	//tester for divide and Conquer used to collect data on time on excel 
	@Test
	void dAndCTImer() 
	{
		testing_helper th = new testing_helper();
		int i =0;
		while(i<=100)
		{
			float time = th.dAndCTimer(i);
			System.out.println(time + "   dAndC  Timer");
			if(i<10) {
				i +=1;
			}
			else 
			{
				i += 10;
			}
		}
		
	}
	//tester for comparing with input file
	@Test
	void filetest() throws FileNotFoundException {
		File file = 
			      new File("resources/maxSumtest.txt");
	Scanner in=new Scanner (file);
	while(in.hasNextLine())
	{
		String line = in.nextLine(); //Each array of numbers is on a single line
		if(line.equals("")) //Takes care of the fact that each array is separated by an empty line
			line = in.nextLine();
		
		String filteredLine = line.substring(1).replaceAll("[^0-9-]", " "); //Replaces all brackets and commas with a space
		String[] valuesAsStr = filteredLine.split("\\s+"); // Fills valuesAsStr with strings containing a single integer value
		int[] values = new int[valuesAsStr.length]; // Creates the integer array that stores the values 
		
		for(int i = 0; i < valuesAsStr.length; i++) // Fills the final array with integers by parsing them one by one from valuesAsStr
		{
			values[i] = Integer.parseInt(valuesAsStr[i]); 
		}
		int[] arr = new int[values.length-3];
		for(int i =0 ;i< values.length-3;i++) 
		{
			arr[i] = values[i];
		}
		int sum = values[values.length-3];
		int arrive = values[values.length-2];
		int depart = values[values.length-1];
		//with bruteForce
		bruteForce br = new bruteForce();
		int[] result = br.findMaxSubarray(arr);
		assertEquals(result[0],sum);
		assertEquals(result[1],arrive);	
		assertEquals(result[2],depart);
		//with kadane
		kadane kd = new kadane();
		int[] k_result = kd.findMaxSubarray(arr);
		assertEquals(k_result[0],sum);
		assertEquals(k_result[1],arrive);	
		assertEquals(k_result[2],depart);
		//divideAndConquer
		divideAndConquer dac = new divideAndConquer();
		int[] dac_result = dac.divideAndConquer(arr);
		assertEquals(dac_result[0],sum);
		assertEquals(dac_result[1],arrive);	
		assertEquals(dac_result[2],depart);
	}

	}

}
