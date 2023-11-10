package medium;

public class SearchInSortedAndRotatedArray {
	public int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high -low)/2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] >= nums[low]) {
				// left half sorted
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				// right half sorted
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchInSortedAndRotatedArray searchInSortedAndRotatedArray = new SearchInSortedAndRotatedArray();
		System.out.println(searchInSortedAndRotatedArray.search(new int[]{4,5,6,7,0,1,2}, 3));
	}

}
