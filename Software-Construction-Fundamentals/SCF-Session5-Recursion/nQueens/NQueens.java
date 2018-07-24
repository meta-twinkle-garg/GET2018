package nQueens;

public class NQueens {
	int N;
	static int board[][];

	public NQueens(int size) {
		N = size;
	}

	public boolean solveProblem() {
		board = new int[N][N];
		for (int count = 0; count < N; count++) {
			for (int count2 = 0; count2 < N; count2++) {
				board[count][count2] = 0;
			}
		}
		if (solveNQUtil(0) == false) {
			System.out.print("Solution does not exist");
			return false;
		}

		printSolution();
		return true;
	}

	void printSolution() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}

	boolean isSafe(int board[][], int row, int col) {
		int i, j;
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	boolean solveNQUtil(int col) {

		if (col >= N)
			return true;

		for (int i = 0; i < N; i++) {

			if (isSafe(board, i, col)) {
				board[i][col] = 1;

				if (solveNQUtil(col + 1) == true) {
					return true;
				}

				board[i][col] = 0;
			}
		}

		return false;
	}
}
