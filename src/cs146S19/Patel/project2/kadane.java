package cs146S19.Patel.project2;

public class kadane {
	//takes array and implements Kadane algorithm for solving maxsubarray
	public static int[] findMaxSubarray(int []arr)
	{
		int maxSum = 0, maxTemp = 0;
        int arrive = -1, depart = -1, tempArrive = 0;

        for (int i = 0, length = arr.length; i < length; i++) {
            
            maxTemp += arr[i];
            if (maxTemp < 0) {
            	maxTemp = 0;
                arrive = i + 1;
            }
            if (maxSum < maxTemp) {
                maxSum = maxTemp;
                depart = i;
                tempArrive = arrive;
            }
            
        }
        arrive = tempArrive;
        //for taking care of corner case if maxsum is negative so no arrival date
        if(maxSum<=0) 
        {
        	return new int[] {0,-1,0};
        }
        else {
        return new int[]{maxSum,arrive, depart};
        }
	}

}
