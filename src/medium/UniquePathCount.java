package medium;

public class UniquePathCount {
	public int uniquePaths(int m, int n) {
		int[][] uniquePathCount = new int[m][n];
		uniquePathCount[0][0] = 0;
		for (int j = 1; j < n; j++)
			uniquePathCount[0][j] = 1;

		for (int i = 1; i < m; i++)
			uniquePathCount[i][0] = 1;
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				uniquePathCount[i][j] = uniquePathCount[i-1][j] + uniquePathCount[i][j-1];
			}
		}
		return uniquePathCount[m-1][n-1];
	}

	public static void main(String[] args) {
		UniquePathCount uniquePathCount = new UniquePathCount();
		System.out.println(uniquePathCount.uniquePaths(3,2));
	}
}
