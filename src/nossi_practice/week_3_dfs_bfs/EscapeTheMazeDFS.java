package nossi_practice.week_3_dfs_bfs;

import java.util.*;

public class EscapeTheMazeDFS {
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,-1,1,0};
    static String[] dir = {"d","l","r","u"};

    int endX;
    int endY;
    int n,m;

    boolean[][][] visited = new boolean[51][51][2501];
    boolean finish = false;
    List<Integer> result;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        this.n = n;
        this.m = m;
        endX = r;
        endY = c;

        dfs(x,y,k,new ArrayList<>());
        StringBuilder sb = new StringBuilder();

        if(result == null) answer = "impossible";
        else {
            // 최종 답안 문자열로 변환
            for(int i : result){
                sb.append(dir[i]);
            }
            answer = sb.toString();
        }
        return answer;
    }

    void dfs(int x, int y, int k, List<Integer> dir){
        if(finish) return; // 정답이 구해졌으므로 중단

        if(k <= 0){ // 주어진 거리에 맞게 도착한 경우
            if(x == endX && y == endY) {
                result = dir;
                finish = true;
            }
            return;
        }

        // 4방향을 사전 순서대로 검사
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > n || ny > m || nx < 1 || ny < 1 || visited[nx][ny][k - 1]) continue;

            visited[nx][ny][k-1] = true;
            List<Integer> list = new ArrayList<Integer>(dir);
            list.add(i);

            dfs(nx,ny,k-1,list);

            if(finish) return; // 정답이 구해졌으므로 중단 -> 전후에 배치
        }
    }
}
