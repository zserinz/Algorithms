package nossi_practice.week_1_exhaustive_search;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] != word.charAt(0)) continue;

                char buffer = board[r][c];
                board[r][c] = '.'; // 방문하면 원본 자체에 .을 찍는다.
                if (backtrack(board, r, c, word, 0)) return true;
                board[r][c] = buffer; // 재귀로 확인하고 다시 원본으로 되돌린다.
            }
        }

        return false;
    }

    int[] dr = { 1, 0, -1, 0 }; // 동서남북
    int[] dc = { 0, 1, 0, -1 };

    boolean backtrack(char[][] board, int r, int c, String word, int count) {
        if (count + 1 == word.length()) return true;

        int m = board.length,
                n = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i],
                    nc = c + dc[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (board[nr][nc] == word.charAt(count+1)) { // backtrack 을 결정하는 큰 차이점
                    char buffer = board[nr][nc];
                    board[nr][nc] = '.';
                    if (backtrack(board, nr, nc, word, count+1)) return true;
                    board[nr][nc] = buffer;
                }
            }
        }

        return false;
    }
}
