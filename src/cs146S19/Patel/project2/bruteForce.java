package cs146S19.Patel.project2;

public class bruteForce {
//takes array of integer and finds Max subarray using brute force
	public int[] findMaxSubarray(int []arr)
	{
		int maxSum = Integer.MIN_VALUE, sum = 0;
        int arrive = 0, depart = 0;
        for (int i = 0, length = arr.length; i < length; i++) {
            sum = 0;
            for (int j = i; j < length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    arrive = i;
                    depart = j;
                }
            }
        }
      //for taking care of corner case if maxsum is negative so no arrival date
        if(maxSum<=0) {
        	maxSum =0;
        	arrive = -1;
        	depart = 0;
        }
        return new int[]{maxSum,arrive, depart}; 
	}
	
}
