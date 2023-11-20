package medium;

import java.util.ArrayList;
import java.util.List;

public class WordSearchInMatrix {
	public boolean exist(char[][] board, String word) {
		int rows = board.length;
		if (rows < 1)
			return false;
		int columns = board[0].length;
		boolean[][] visited;
		char startingChar = word.charAt(0);
		List<int[]> startingIndices = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (board[i][j] == startingChar)
					startingIndices.add(new int[]{i,j});
			}
		}
		for (int[] index : startingIndices) {
			visited = new boolean[rows][columns];
			visited[index[0]][index[1]] = true;
			if (exist(board, word, 1, visited, index[0], index[1], rows, columns))
				return true;
		}
		return false;
	}

	private boolean exist(char[][] board, String word, int i, boolean[][] visited, int x, int y, int rows, int columns) {
		if (i == word.length())
			return true;
		List<int[]> neighbourIndices = getValidNeighbouringIndex(x, y, word.charAt(i), rows, columns, visited, board);
		for (int[] neighbourIdx : neighbourIndices) {
			int idx = neighbourIdx[0], idy = neighbourIdx[1];
			visited[idx][idy] = true;
			if (exist(board, word, i+1, visited, idx, idy, rows, columns))
				return true;
			else
				visited[idx][idy] = false;
		}
		return false;
	}

	private List<int[]> getValidNeighbouringIndex(int x, int y, char ch, int rows, int columns, boolean[][] visited, char[][] board) {
		List<int[]> indices = new ArrayList<>();
		if (x + 1 < rows && !visited[x+1][y] && board[x+1][y] == ch)
			indices.add(new int[]{x+1, y});
		if (x - 1 >= 0 && !visited[x-1][y] && board[x-1][y] == ch)
			indices.add(new int[]{x-1, y});
		if (y + 1 < columns && !visited[x][y+1] && board[x][y+1] == ch)
			indices.add(new int[]{x, y+1});
		if (y - 1 >= 0 && !visited[x][y-1] && board[x][y-1] == ch)
			indices.add(new int[]{x, y-1});
		return indices;
	}

	public static void main(String[] args) {
		WordSearchInMatrix wordSearchInMatrix = new WordSearchInMatrix();
		System.out.println(wordSearchInMatrix.exist(new char[][] {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCB"));
	}
}
