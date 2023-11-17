package medium;

public class SortColors {
	public void sortColors(int[] nums) {
		int zeroCount = 0, oneCount = 0, twoCount = 0;
		for (int i : nums) {
			if (i == 0) zeroCount++;
			else if (i == 1) oneCount++;
			else twoCount++;
		}
		int limit = zeroCount;
		int fill = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i < limit) {
				nums[i] = fill;
			}
			else {
				if (fill == 0) {
					fill = 1;
					limit += oneCount;
				} else {
					fill = 2;
					limit += twoCount;
				}
				i--;
			}
		}
	}

	public static void main(String[] args) {
		SortColors sortColors = new SortColors();
		int[] nums = {2, 2, 2, 2, 2, 2};
		for (int i : nums) {
			System.out.println(i);
		}
		sortColors.sortColors(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

}
