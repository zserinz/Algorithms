package nossi_practice.week_3_dfs_bfs;

import java.util.*;
public class ShortestPathInBinaryMatrix {
    static int rowLength;
    static int colLength;
    static boolean[][] visited;
    private static final int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int clearPathLength = -1;
        rowLength = grid.length;
        colLength = grid[0].length;
        visited = new boolean[rowLength][colLength];
        Queue<int[]> queue = new LinkedList<>();

        // 기본 조건 검사
        if (grid[0][0] != 0 || grid[rowLength - 1][colLength - 1] != 0) return clearPathLength;

        // 시작 지점 세팅
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], length = current[2];

            // 최종 도착지일 경우 답안 제출
            if (row == rowLength - 1 && col == colLength - 1) {
                return length;
            }

            // 8가지 방향 검사
            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                boolean isRowValid = nextRow >= 0 && nextRow < rowLength;
                boolean isColValid = nextCol >= 0 && nextCol < colLength;

                if (isRowValid && isColValid) {
                    boolean isCellUnvisitedAndOpen = grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol];

                    if (isCellUnvisitedAndOpen) {
                        queue.offer(new int[]{nextRow, nextCol, length + 1});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }

        return -1;
    }
}
