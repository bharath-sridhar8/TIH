import java.util.LinkedList;

public class FloodFill {

	public static void main(String[] args) {
		FloodFill floodFill = new FloodFill();
		int[][] ints = floodFill.floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0);
		for (int[] i : ints)
			for (int j : i)
				System.out.println(j);
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		if (image[sr][sc] == color)
			return image;
		LinkedList<int[]> queue = new LinkedList<>();
		queue.addLast(new int[] {sr, sc});
		int rows = image.length;
		int columns = image[0].length;
		int[][] visited = new int[rows][columns];
		while (!queue.isEmpty()) {
			int[] pixel = queue.removeFirst();
			int i = pixel[0];
			int j = pixel[1];
			int currValue = image[i][j];
			if (i + 1 < rows && image[i + 1][j] == currValue && visited[i + 1][j] == 0) {
				queue.addLast(new int[] {i + 1, j});
			}
			if (i - 1 >= 0 && image[i - 1][j] == currValue && visited[i - 1][j] == 0) {
				queue.addLast(new int[] {i - 1, j});
			}
			if (j + 1 < columns && image[i][j + 1] == currValue && visited[i][j + 1] == 0) {
				queue.addLast(new int[] {i, j + 1});
			}
			if (j - 1 >= 0 && image[i][j - 1] == currValue && visited[i][j - 1] == 0) {
				queue.addLast(new int[] {i, j - 1});
			}
			image[i][j] = color;
			visited[i][j] = 1;
		}
		return image;
	}
}
