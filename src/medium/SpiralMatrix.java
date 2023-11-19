package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	private boolean canGoDown(int i, int j, boolean[][] visited, int rows) {
		return i < rows - 1 && !visited[i+1][j];
	}
	
	private boolean canGoRight(int i, int j, boolean[][] visited, int columns) {
		return j < columns - 1 && !visited[i][j+1];
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		int rows = matrix.length;
		if (rows == 0)
			return new ArrayList<>();
		int columns = matrix[0].length;
		boolean[][] visited = new boolean[rows][columns];
		int[] directions = new int[]{0,1,2,3};
		
		List<Integer> result = new ArrayList<>();
		
		int i =0, j = 0;
		int direction = directions[0];
		
		while (true) {
			if (!visited[i][j]) {
				result.add(matrix[i][j]);
				visited[i][j] = true;
				if (direction == 0) {
					if (canGoRight(i, j, visited, columns)) {
						j++;
					} else if (canGoDown(i, j, visited, rows)) {
						direction = (direction + 1) % 4;
						i++;
					} else {
						break;
					}
				} else if (direction == 1) {
					if (canGoDown(i, j, visited, rows)) {
						i++;
					} else if (canGoLeft(i, j, visited)) {
						direction = (direction + 1) % 4;
						j--;
					} else
						break;
				} else if (direction == 2) {
					if (canGoLeft(i, j, visited)) {
						j--;
					} else if (canGoUp(i, j, visited)) {
						direction = (direction + 1) % 4;
						i--;
					} else
						break;
				} else {
					if (canGoUp(i, j, visited)) {
						i--;
					} else if (canGoRight(i, j, visited, columns)) {
						direction = (direction + 1) % 4;
						j++;
					} else
						break;
				}
			}
		}
		return result;
	}

	private boolean canGoUp(int i, int j, boolean[][] visited) {
		return i - 1 > 0 && !visited[i-1][j];
	}

	private boolean canGoLeft(int i, int j, boolean[][] visited) {
		return j > 0 && !visited[i][j-1];
	}

	public static void main(String[] args) {
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		System.out.println(spiralMatrix.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
	}
}
