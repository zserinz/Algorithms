package nossi_practice.week_3_dfs_bfs;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    static int rowLength;
    static int colLength;
    static boolean[][] visited;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};


    public int numIslands1(char[][] grid) {
        int numIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // grid 순회 시작
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    dfs1(grid, row, col, visited);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    private void dfs1(char[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        dfs1(grid, row + 1, col, visited);
        dfs1(grid, row - 1, col, visited);
        dfs1(grid, row, col + 1, visited);
        dfs1(grid, row, col - 1, visited);
    }

    public int numIslands2(char[][] grid) {
        int islandCount = 0;
        rowLength = grid.length;
        colLength = grid[0].length;
        visited = new boolean[rowLength][colLength];

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    dfs2(row, col, grid);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    // 개선 1) isValid 함수의 if 조건 구문 분리
    public static boolean isValid(int r, int c, char[][] grid, boolean[][] visited) {
        // 1. 행 인덱스 범위 확인
        boolean isRowValid = (r >= 0 && r < rowLength);

        // 2. 열 인덱스 범위 확인
        boolean isColValid = (c >= 0 && c < colLength);

        if (!isRowValid || !isColValid) {
            return false;
        }

        // 3. 방문하지 않은 육지인지 확인
        boolean isLand = (grid[r][c] == '1' && !visited[r][c]);

        return isLand;
    }

    private void dfs2(int r, int c, char[][] grid) {
        visited[r][c] = true;

        // 개선 2) 4사분면 방향 검사를 반복문으로 작성
        for (int i = 0; i < 4; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];
            if (isValid(nextRow, nextCol, grid, visited)) {
                dfs2(nextRow, nextCol, grid);
            }
        }
    }
}
