public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.search(new int[]{-1,0,3,5,9,12}, -2));
	}

	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int value = nums[mid];
			if (value == target) {
				return mid;
			} else if (target < value) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
