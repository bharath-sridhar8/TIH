package medium;

public class SortColorsOnePass {
	public void sortColors(int[] nums) {
		if (nums.length <= 1)
			return;
		int insertZeroIdx = 0;
		int insertTwoIdx = nums.length - 1;
		int compareIdx = insertZeroIdx;
		while (compareIdx <= insertTwoIdx) {
			if (nums[compareIdx] == 2) {
				int tmp = nums[insertTwoIdx];
				nums[insertTwoIdx--] = 2;
				nums[compareIdx] = tmp;
			} else if (nums[compareIdx] == 0) {
				int tmp = nums[insertZeroIdx];
				nums[insertZeroIdx++] = 0;
				nums[compareIdx++] = tmp;
			} else {
				compareIdx++;
			}
		}
	}

	public static void main(String[] args) {
		SortColorsOnePass sortColorsOnePass = new SortColorsOnePass();
		int[] nums = {2, 2, 1, 0, 0, 1};
		for (int i : nums) {
			System.out.println(i);
		}
		sortColorsOnePass.sortColors(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
