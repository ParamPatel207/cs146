package cs146S19.Patel.project2;

public class divideAndConquer {
	//implementing divide and conquer using helper methods
	int[] divideAndConquer(int arr[]){
	int[] result = findMaximumSubarray(arr, 0, arr.length-1);
	//taking care of corner case of no arrival if sum is negative
	if (result[2] <= 0) 
	{
		result[2] = 0;
		result[0] = -1;
		result[1] = 0;
	}
	int[] final_result = new int[]{result[2],result[0],result[1]};
	return final_result;
	}
	//find maxsubarray on both side of divided array and also compare it with max of cross subarray
	private static int[] findMaximumSubarray(int[] a, int low, int high) {
        if (low == high) return new int[]{low, high, a[low]};
        
        int mid = (low + high) / 2;
        int[] left = findMaximumSubarray(a, low, mid);
        int[] right = findMaximumSubarray(a, mid + 1, high);
        int[] cross = findMaxCrossingSubarray(a, low, mid, high);

        if (left[2] >= right[2] && left[2] >= cross[2])
            return left;
        else if (right[2] >= cross[2]) 
            return right;
        else 
            return cross;
    }

    //finds max crossing subarray
    private static int[] findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int maxLeft = -1, maxRight = -1;

        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (leftSum < sum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (rightSum < sum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        return new int[]{maxLeft, maxRight, (leftSum + rightSum)};
    }
}
