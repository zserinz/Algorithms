package nossi_practice.week_3_dfs_bfs;

import java.util.*;

/**
 * 인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
 *
 * 연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
 *
 * 일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
 *
 * 예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.
 *
 * 2 0 0 0 1 1 0
 * 0 0 1 0 1 2 0
 * 0 1 1 0 1 0 0
 * 0 1 0 0 0 0 0
 * 0 0 0 0 0 1 1
 * 0 1 0 0 0 0 0
 * 0 1 0 0 0 0 0
 * 이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
 *
 * 2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.
 *
 * 2 1 0 0 1 1 0
 * 1 0 1 0 1 2 0
 * 0 1 1 0 1 0 0
 * 0 1 0 0 0 1 0
 * 0 0 0 0 0 1 1
 * 0 1 0 0 0 0 0
 * 0 1 0 0 0 0 0
 * 바이러스가 퍼진 뒤의 모습은 아래와 같아진다.
 *
 * 2 1 0 0 1 1 2
 * 1 0 1 0 1 2 2
 * 0 1 1 0 1 2 2
 * 0 1 0 0 0 1 2
 * 0 0 0 0 0 1 1
 * 0 1 0 0 0 0 0
 * 0 1 0 0 0 0 0
 * 벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.
 *
 * 연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.
 */
public class Laboratory {
    static int N, M;
    static int[][] map;
    static int[][] virusMap;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int maxSafeArea = 0;

    public static void main(String[] args) {
        // 예제 입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 벽 짓기 시작 위치 세팅
        buildWall(0, 0, 0);

        // 예제 출력
        System.out.println(maxSafeArea);
    }

    public static int currentSafeArea() {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        return safeArea;
    }

    public static void spreadVirus() {
        virusMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = map[i][j];
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = current[0] + dr[i];
                int nextCol = current[1] + dc[i];

                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                    if (virusMap[nextRow][nextCol] == 0) { // 빈 구역일 때
                        virusMap[nextRow][nextCol] = 2; // 바이러스 감염
                        queue.add(new int[]{nextRow, nextCol}); // 다음 지역으로 이동
                    }
                }
            }
        }
    }

    public static void buildWall(int count, int row, int col) {
        // 벽에 3개이면 바이러스 확산 진행
        if (count == 3) {
            spreadVirus();
            maxSafeArea = Math.max(maxSafeArea, currentSafeArea());
            return;
        }

        // 0(빈 구역)에 1(벽) 세우기 -> 재귀 반복
        for (int i = row; i < N; i++, col = 0) {
            System.out.println("row" + i);
            for (int j = col; j < M; j++) {
                System.out.println("col" + j);
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count + 1, i, j + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
