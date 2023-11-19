package medium;

public class ContainerMostWater {
	public int maxArea(int[] height) {
		int low = 0;
		int high = height.length - 1;
		int area = 0;
		while (low < high) {
//			System.out.println(area);
			area = Math.max(area, Math.min(height[low], height[high]) * (high - low));
			if (height[low] <= height[high]) {
				low++;
			} else {
				high--;
			}
		}
//		System.out.println(area);
		return area;
	}

	public static void main(String[] args) {
		ContainerMostWater containerMostWater = new ContainerMostWater();
		System.out.println(containerMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
	}
}
