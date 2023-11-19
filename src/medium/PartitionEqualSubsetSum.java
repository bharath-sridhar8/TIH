package medium;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		// calc sum of nums. 2 partitions of equal sum => find a subset of sum total / 2.
		int sum = 0;
		for (int i : nums) sum += i;
		if (sum % 2 != 0) return false;
		int subSetSum = sum / 2;
		boolean[] dp = new boolean[subSetSum + 1];
		dp[0] = true;
//		for (boolean j : dp) {
//			System.out.println(j);
//		}
		for (int k = 1; k < nums.length + 1; k++) {
			int cur = nums[k - 1];
//			System.out.println(cur);
			for (int i = subSetSum; i >= 0; i--) {
				boolean prev = dp[i];
				if (cur <= i) {
					dp[i] = prev || dp[i-cur];
				}
			}
//			for (boolean j : dp) {
//				System.out.println(j);
//			}
		}
		return dp[subSetSum];
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
		System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1,2,5}));
	}
}
