package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		List<List<Integer>> permute = permutations.permute(new int[]{1,2,3,4});
		for (List<Integer> list : permute) {
			System.out.println(list);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		return permute(nums, nums.length, 0, nums.length);
	}

	private List<List<Integer>> permute(int[] nums, int size, int start, int end) {
		List<List<Integer>> result = new ArrayList<>();
		if (size == 0) {
			result.add(new ArrayList<>());
			return result;
		}
		for (int i = start; i < end; i++) {
			swap(nums, start, i);
			List<List<Integer>> childResult = permute(nums, size - 1, start + 1, end);
			for (List<Integer> permutation : childResult) {
				LinkedList list = new LinkedList<>(permutation);
				list.addFirst(nums[start]);
				result.add(list);
			}
			swap(nums, i, start);
		}
		return result;
	}

	private void swap(int[] nums, int start, int i) {
		int tmp = nums[start];
		nums[start] = nums[i];
		nums[i] = tmp;
	}
}
