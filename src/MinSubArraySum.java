public class MinSubArraySum {

	public static void main(String[] args) {
		int[] array = {2,3,1,-2,7};
		int target = 7;
		System.out.println(minSubArraySize(array, target));
	}

	private static int minSubArraySize(int[] array, int target) {
		// sliding window - sum, minWindowSize
		// expand window while sum < target, update sum.
		// if sum >= target
		//  note the windowSize. If windowSize smaller than minWindowSize, set minWindowSize = windowSize, 
		//  shrink window until sum < target 

		if (array.length < 1) {
			return 0;
		}

		int start = 0, end = 0, sum = 0;
		int minWindowSize = Integer.MAX_VALUE;

		while (end < array.length) {
			sum += array[end];
			while (sum >= target) {
				int windowSize = end - start + 1;
				if (windowSize < minWindowSize) {
					minWindowSize = windowSize;
				}

				sum -= array[start];
				start++;
			}
			end++;
		}
		
		return minWindowSize < Integer.MAX_VALUE ? minWindowSize : 0;
	}

}
