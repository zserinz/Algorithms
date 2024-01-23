package nossi_practice.week_3_dfs_bfs;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // grid 순회 시작
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    dfs(grid, row, col, visited);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);
    }
}
