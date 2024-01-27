package nossi_practice.week_3_dfs_bfs;

/**
 * https://leetcode.com/problems/minesweeper/description/
 */
public class Minesweeper {
    int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            dfs(board, row, col);
        }

        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        int mines = countAdjacentMines(board, row, col);

        if (mines > 0) {
            board[row][col] = (char) ('0' + mines);
        } else {
            board[row][col] = 'B';

            for (int i = 0; i < 8; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (isValid(board, newRow, newCol) && board[newRow][newCol] == 'E') {
                    dfs(board, newRow, newCol);
                }
            }
        }
    }

    private int countAdjacentMines(char[][] board, int row, int col) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (isValid(board, newRow, newCol) && board[newRow][newCol] == 'M') {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
