package medium;

public class MaxSubArraySum {

	public static void main(String[] args) {
		MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
		System.out.println(maxSubArraySum.maxSubArray(new int[]{8, -19, 5, -4, 20}));
	}

	public int maxSubArray(int[] nums) {
		// ti : sum, startIdx, endIdx
		// tn = max(an, sum(tn-1startIdx, an))
		// t0 = a0, 0, 0;
		// t1 = max(a1, sum(0,1))
		// t1 = max(1, -1)
		// t1 = 1, 1, 1
		if (nums.length == 0)
			return -1;
		int sum = nums[0], startIdx = 0, endIdx = 0;

		for (int i = 1; i < nums.length; i++) {
			int prevSum = sum;
			for (int j = endIdx + 1; j <= i; j++) {
				prevSum += nums[j];
			}
			if (nums[i] >= prevSum && nums[i] >= sum) {
				sum = nums[i];
				startIdx = endIdx = i;
			} else if (prevSum > nums[i] && prevSum > sum){
				sum = prevSum;
				endIdx = i;
			}
		}

//		System.out.println(startIdx + " : " + endIdx);
		return sum;
	}
}
