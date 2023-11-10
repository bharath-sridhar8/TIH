package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	private List<List<Integer>> result;
	private List<Integer> combination;
	private int[] candidates;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		this.result = new ArrayList<>();
		this.combination = new ArrayList<>();
		this.candidates = candidates;
		findCombinations(target, 0);
		return result;
	}

	private void findCombinations(int target, int idx) {
		if (target == 0) {
			result.add(new ArrayList<>(combination));
		}
		for (int i = idx; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				combination.add(candidates[i]);
				findCombinations(target - candidates[i], i);
				combination.remove(combination.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		CombinationSum combinationSum = new CombinationSum();
		List<List<Integer>> result = combinationSum.combinationSum(new int[]{2, 3, 5, 7}, 7);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

}
