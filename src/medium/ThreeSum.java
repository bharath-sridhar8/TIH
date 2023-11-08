package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		List<List<Integer>> lists = threeSum.threeSum(new int[]{0,0,0});
		for (List<Integer> list : lists) {
			System.out.println(list);
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {
		// 2 sum is either - O(nlogn) OR O(n)
		// 3sum on top of 2sum would be O(n2) if using map.
		// 3sum on top of 2sum with sorting. O(nlogn) for sort. O(n) for each i to find the 2 sum => O(n2) itself
		// So, sort or map ? Map is going to be n2 in the worst case when the array is full of the same number.
		if (nums.length < 3)
			return Collections.emptyList();

		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Set<Integer>> firstNumMap = new HashMap<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int twosum = nums[start] + nums[end];
				if (twosum == -nums[i]) {
					result.add(Arrays.asList(nums[i], nums[start], nums[end]));
					while (start < nums.length - 1 && nums[start] == nums[start + 1]) start++;
					while (end > 0 && nums[end] == nums[end - 1]) end--;
					start++;
					end--;
				} else if (twosum < -nums[i]) {
					start++;
				} else {
					end--;
				}
			}
		}
		return result;
	}

}
