import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		int[] ints = twoSum(new int[]{2, 7, 11, 15}, 27);
		for (int i : ints) {
			System.out.println(i);
		}
	}
	
	private static int[] twoSum(int[] nums, int target) {
		int[] defaultAns = {-1, -1};
		if ( nums.length <= 1)
			 return defaultAns;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target)
					return new int[] {i, j};
			}
		}
		return defaultAns;
	}

}
