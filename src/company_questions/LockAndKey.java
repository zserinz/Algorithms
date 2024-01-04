package company_questions;

/**
 * 고고학자인 "튜브"는 고대 유적지에서 보물과 유적이 가득할 것으로 추정되는 비밀의 문을 발견하였습니다. 그런데 문을 열려고 살펴보니 특이한 형태의 자물쇠로 잠겨 있었고 문 앞에는 특이한 형태의 열쇠와 함께 자물쇠를 푸는 방법에 대해 다음과 같이 설명해 주는 종이가 발견되었습니다.
 * 잠겨있는 자물쇠는 격자 한 칸의 크기가 1 x 1인 N x N 크기의 정사각 격자 형태이고 특이한 모양의 열쇠는 M x M 크기인 정사각 격자 형태로 되어 있습니다.
 * 자물쇠에는 홈이 파여 있고 열쇠 또한 홈과 돌기 부분이 있습니다. 열쇠는 회전과 이동이 가능하며 열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열리게 되는 구조입니다. 자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는 데 영향을 주지 않지만, 자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안됩니다. 또한 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 자물쇠를 열 수 있습니다.
 * 열쇠를 나타내는 2차원 배열 key와 자물쇠를 나타내는 2차원 배열 lock이 매개변수로 주어질 때, 열쇠로 자물쇠를 열수 있으면 true를, 열 수 없으면 false를 return 하도록 solution 함수를 완성해주세요.
 */
public class LockAndKey {
    public boolean solution1(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        for (int offsetRow = m; offsetRow > -n; offsetRow--) {
            for (int offsetCol = m; offsetCol > -n; offsetCol--) {
                if (matchKey(offsetCol, offsetRow, key, lock)) return true;
            }
        }

        return false;
    }

    boolean matchKey(int offsetCol, int offsetRow, int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        for (int rot = 0; rot < 4; rot++) {
            boolean match = true;
            outer: for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int keyPoint = 0;
                    int keyCol = c + offsetCol,
                            keyRow = r + offsetRow;
                    if (keyCol >= 0 && keyCol < m && keyRow >= 0 && keyRow < m) {
                        keyPoint = getKeyPoint(key, keyCol, keyRow, rot);
                    }
                    if ((lock[r][c] == 1 && keyPoint == 1) ||
                            (lock[r][c] == 0 && keyPoint == 0)) {
                        match = false;
                        break outer;
                    }
                }
            }
            if (match) return true;
        }
        return false;
    }

    int getKeyPoint(int[][] key, int c, int r, int rotation) {
        int m = key.length;
        switch (rotation) {
            case 0: return key[r][c];
            case 1: return key[c][m-1-r];
            case 2: return key[m-1-r][m-1-c];
            case 3: return key[m-1-c][r];
        }
        return -1;
    }

    public boolean solution2(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;

        int[][] extendedLock = new int[N * 3][N * 3];
        for (int i = N; i < N * 2; i++) {
            for (int j = N; j < N * 2; j++) {
                extendedLock[i][j] = lock[i - N][j - N];
            }
        }

        for (int rotation = 0; rotation < 4; key = rotateKey(key), rotation++) {
            for (int x = 0; x < N * 2; x++) {
                for (int y = 0; y < N * 2; y++) {
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            extendedLock[x + i][y + j] += key[i][j];
                        }
                    }

                    if (isUnlock(N, extendedLock)) return true;

                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            extendedLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }

        return false;
    }

    private int[][] rotateKey(int[][] key) {
        int M = key.length;
        int[][] rotated = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M - 1 - i] = key[i][j];
            }
        }
        return rotated;
    }

    private boolean isUnlock(int N, int[][] extendedLock) {
        for (int i = N; i < N * 2; i++) {
            for (int j = N; j < N * 2; j++) {
                if (extendedLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
