package cs146S19.Patel.project2;

import java.util.Random;

public class testing_helper {

//generates random array of size n
	public int[] generateRandomArray(int n) {
		int[] list = new int[n+1];
	    Random random = new Random();

	    for (int i = 0; i < n; i++)
	    {
	        list[n] = random.nextInt(n)-n/2;
	    }
	   return list;
	}  
//takes size and implements bruteforce for finding maxSumArray
	public float bruteForceTimer(int size) 
	{
		bruteForce bf = new bruteForce();
		long elapsed_time = 0;
		for(int i =0; i<101;i++)
		{
			int[] ran_array = generateRandomArray(size);
			long startClock = System.nanoTime();
			bf.findMaxSubarray(ran_array);
			long stopClock = System.nanoTime();
			long time = stopClock - startClock;
			elapsed_time += time;
		}
		
		return elapsed_time/100;
	}
	//takes size and implements kadane for finding maxSumArray
	public float kadaneTimer(int size)
	{
		kadane kd = new kadane();
		testing_helper hp = new testing_helper();
		long elapsed_time = 0;
		for(int i =0; i<101;i++)
		{
			int[] ran_array = hp.generateRandomArray(size);
			long startClock = System.nanoTime();
			kd.findMaxSubarray(ran_array);
			long stopClock = System.nanoTime();
			long time = stopClock - startClock;
			elapsed_time += time;
		}
		return elapsed_time/100;
	}
	//takes size and implements D&CTimer for finding maxSumArray
	public float dAndCTimer(int size)
	{
		divideAndConquer dac = new divideAndConquer();
		testing_helper hp = new testing_helper();
		long elapsed_time = 0;
		for(int i =0; i<101;i++)
		{
			int[] ran_array = hp.generateRandomArray(size);
			long startClock = System.nanoTime();
			dac.divideAndConquer(ran_array);
			long stopClock = System.nanoTime();
			long time = stopClock - startClock;
			elapsed_time += time;
			
		}
		return elapsed_time/100;
	}
	
	
}
