package medium;

import java.util.LinkedList;

public class Nearest0MatrixMultiSourceBFS {

	public static void main(String[] args) {
		Nearest0MatrixMultiSourceBFS nearest0Matrix = new Nearest0MatrixMultiSourceBFS();
		int[][] ints = nearest0Matrix.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1,1,1}});
		for (int[] arr : ints) {
			for (int i : arr) {
				System.out.println(i);
			}
		}
	}

	public int[][] updateMatrix(int[][] mat) {
		int[][] distance = new int[mat.length][mat[0].length];
		int[][] visited = new int[mat.length][mat[0].length];
		LinkedList<int[]> nodes = new LinkedList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					distance[i][j] = 0;
					visited[i][j] = 1;
					nodes.add(new int[]{i, j});
				}
			}
		}

		while (!nodes.isEmpty()) {
			int[] ints = nodes.removeFirst();
			int i = ints[0];
			int j = ints[1];
			if (i + 1 < mat.length && mat[i+1][j] != 0 && visited[i+1][j] == 0) {
				distance[i+1][j] = distance[i][j] + 1;
				visited[i+1][j] = 1;
				nodes.addLast(new int[]{i+1,j});
			}
			if (i - 1 >=0 && mat[i-1][j] != 0 && visited[i-1][j] == 0) {
				distance[i-1][j] = distance[i][j] + 1;
				visited[i-1][j] = 1;
				nodes.addLast(new int[]{i-1,j});
			}
			if (j+1 < mat[0].length && mat[i][j+1] != 0 && visited[i][j+1] == 0) {
				distance[i][j+1] = distance[i][j] + 1;
				visited[i][j+1] = 1;
				nodes.addLast(new int[]{i, j+1});
			}
			if (j-1 >= 0 && mat[i][j-1] != 0 && visited[i][j-1] == 0) {
				distance[i][j-1] = distance[i][j] + 1;
				visited[i][j-1] = 1;
				nodes.addLast(new int[]{i, j-1});
			}
			visited[i][j] = 1;
		}
		
		return distance;
	}

}
