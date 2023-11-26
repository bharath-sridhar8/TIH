package hard;

public class TrappingRainWater {
	public int trap(int[] height) {
//		prepare leftMax;
//		prepare rightMax;
//		For all i, water[i] = min(leftMax[i], rightMax[i]) - height[i];
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		leftMax[0] = height[0];
		for (int i = 1; i < height.length; i++)
			leftMax[i] = Math.max(height[i], leftMax[i-1]);
		rightMax[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i --)
			rightMax[i] = Math.max(height[i], rightMax[i+1]);
		int water = 0;
		for (int i = 0; i < height.length; i++)
			water += Math.min(leftMax[i], rightMax[i]) - height[i];
		return water;
	}

	public static void main(String[] args) {
		TrappingRainWater trappingRainWater = new TrappingRainWater();
		System.out.println(trappingRainWater.trap(new int[]{4,2,0,3,2,5}));
	}
}
