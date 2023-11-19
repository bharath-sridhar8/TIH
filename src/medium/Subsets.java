package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		return subsets(nums, nums.length);
	}

	private List<List<Integer>> subsets(int[] nums, int length) {
		if (length == 0) {
			List<List<Integer>> integers = new ArrayList<>();
			integers.add(new ArrayList<>());
			return integers;
		}
		List<List<Integer>> subsets = subsets(nums, length - 1);
		List<List<Integer>> setsToAdd = new ArrayList<>();
		for (List<Integer> set : subsets) {
			ArrayList<Integer> integers = new ArrayList<>(set);
			integers.add(nums[length - 1]);
			setsToAdd.add(integers);
		}
		subsets.addAll(setsToAdd);
		return subsets;
	}

	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		List<List<Integer>> subsets1 = subsets.subsets(new int[]{1, 2, 3});
		for (List<Integer> set : subsets1) {
			System.out.println(set);
		}
	}
}
