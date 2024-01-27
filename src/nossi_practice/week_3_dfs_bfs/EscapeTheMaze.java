package nossi_practice.week_3_dfs_bfs;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150365d
 */
public class EscapeTheMaze {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};

    public char directionToChar(int d) {
        if (d == 0) return 'd';
        if (d == 1) return 'l';
        if (d == 2) return 'r';
        if (d == 3) return 'u';
        return '0';
    }

    public static class Point {
        public int x,y;
        public StringBuilder sb;

        public Point(int x, int y, StringBuilder sb) {
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
    }

    public String solution1(int n, int m, int x, int y, int r, int c, int k) {
        boolean[][][] visited = new boolean[n][m][k + 1];
        Queue<Point> queue = new LinkedList<>();

        // 시작점 세팅
        queue.add(new Point(x - 1, y - 1, new StringBuilder()));
        visited[x -1][y - 1][0] = true;

        while(!queue.isEmpty()) {
            Point current  = queue.poll();

            // 정답 제출 조건
            if (current.x == r -1 && current.y == c - 1 && current.sb.toString().length() == k) {
                return current.sb.toString();
            }

            // 도착 지점이 아닌데 주어진 경로에 도달했다면 경로 탐색 중단
            if (current.sb.toString().length() == k) continue;

            // 4방향을 사전 순서대로 검사
            for (int d = 0; d < 4; d++) {
                int nextX = current.x + dx[d];
                int nextY = current.y + dy[d];

                if (nextX < 0 || nextX >= n || nextY <0 || nextY >= m
                        || visited[nextX][nextY][current.sb.toString().length() + 1])
                    continue;

                visited[nextX][nextY][current.sb.toString().length() + 1] = true;
                queue.add(new Point(nextX, nextY, new StringBuilder(current.sb).append(directionToChar(d))));
            }
        }

        return "impossible";
    }
}
