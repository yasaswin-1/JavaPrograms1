import java.util.Scanner;

public class SimpleNQueens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of queens: ");
        int N = scanner.nextInt();
        int[][] board = new int[N][N];

        // Backtracking
        if (solve(board, 0, N)) {
            // Printing the solution
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] == 1 ? " Q " : " . ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Solution does not exist");
        }
        scanner.close();
    }

    private static boolean solve(int[][] board, int col, int N) {
        if (col >= N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;
                if (solve(board, col + 1, N)) {
                    return true;
                }
                board[i][col] = 0; // Backtrack
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int N) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
