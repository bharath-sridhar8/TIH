package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NumberOfIslands {

	public static void main(String[] args) {
		NumberOfIslands numberOfIslands = new NumberOfIslands();
		System.out.println(numberOfIslands.numIslands(new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}}));
	}
	
	public int numIslands(char[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int rows = grid.length;
		int columns = grid[0].length;
		int islandNum = 0;
		LinkedList<List<Integer>> queue = new LinkedList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (!visited[i][j] && grid[i][j] != '0') {
					islandNum++;
					visited[i][j] = true;
					queue.addLast(Arrays.asList(i, j));
					while (!queue.isEmpty()) {
						List<Integer> integers = queue.removeFirst();
						int x = integers.get(0);
						int y = integers.get(1);
						if (x + 1 < rows && !visited[x+1][y] && grid[x+1][y] != '0') {
							visited[x+1][y] = true;
							queue.addLast(Arrays.asList(x+1, y));
						}
						if (x - 1 >= 0 && !visited[x-1][y] && grid[x-1][y] != '0') {
							visited[x-1][y] = true;
							queue.addLast(Arrays.asList(x-1, y));
						}
						if (y + 1 < columns && !visited[x][y + 1] && grid[x][y + 1] != '0') {
							visited[x][y + 1] = true;
							queue.addLast(Arrays.asList(x, y + 1));
						}
						if (y - 1 >= 0 && !visited[x][y - 1] && grid[x][y - 1] != '0') {
							visited[x][y - 1] = true;
							queue.addLast(Arrays.asList(x, y - 1));
						}
					}
				}
			}
		}
		return islandNum;
	}
}
