package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RottingOranges {

	public static void main(String[] args) {
		RottingOranges rottingOranges = new RottingOranges();
		System.out.println(rottingOranges.orangesRotting(new int[][]{{0,2}}));
	}
	
	public int orangesRotting(int[][] grid) {
		int minuteCount = 0;
		LinkedList<List<Integer>> queue = new LinkedList<>();
		int rows = grid.length;
		int columns = grid[0].length;
		boolean[][] visited = new boolean[rows][columns];
		// iterate through the grid and place the rotten orange indices into a queue.
		int freshOrangeCount = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == 2) {
					visited[i][j] = true;
					queue.addLast(Arrays.asList(i,j));
				} else if (grid[i][j] == 1) {
					freshOrangeCount++;
				}
			}
		}
		// if queue is empty
		if (queue.isEmpty()) {
			if (freshOrangeCount == 0)
				return 0;
			else
				return -1;
		} else {
			// else add `null` to indicate the end of a level of BFS
			queue.add(null);
		}
		
		// while queue is not empty
		while (!queue.isEmpty()) {
			List<Integer> integers = queue.removeFirst();
			if (integers == null) {
				//     when the removed value is `null` & queue is not empty, increment `minuteCount`;
				if (!queue.isEmpty()) {
					minuteCount++;
					queue.addLast(null);
				}
			} else {
				//     remove idx, add indices of adjacent non-visited fresh oranges into queue
				int x = integers.get(0);
				int y = integers.get(1);
				if (x+1 < rows && !visited[x+1][y] && grid[x+1][y] == 1) {
					visited[x+1][y] = true;
					grid[x+1][y] = 2;
					freshOrangeCount--;
					queue.addLast(Arrays.asList(x+1, y));
				}
				if (x-1 >= 0 && !visited[x-1][y] && grid[x-1][y] == 1) {
					visited[x-1][y] = true;
					grid[x-1][y] = 2;
					freshOrangeCount--;
					queue.addLast(Arrays.asList(x-1, y));
				}
				if (y+1 < columns && !visited[x][y+1] && grid[x][y+1] == 1) {
					visited[x][y+1] = true;
					grid[x][y+1] = 2;
					freshOrangeCount--;
					queue.addLast(Arrays.asList(x, y+1));
				}
				if (y-1 >= 0 && !visited[x][y-1] && grid[x][y-1] == 1) {
					visited[x][y-1] = true;
					grid[x][y-1] = 2;
					freshOrangeCount--;
					queue.addLast(Arrays.asList(x, y-1));
				}
			}
		}
		// scan the matrix for fresh oranges, if any return -1, else return `minuteCount`
		return freshOrangeCount > 0 ? -1 : minuteCount;
	}

}
