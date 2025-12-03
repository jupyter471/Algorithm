import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int ans;
    static int[][] dp; //dp[i][j] : (i,j)에서 목적지까지 가는 경로 수
    static boolean[][] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];
        v = new boolean[N][M];
        //dfs
        System.out.println(dfs(0,0));


    }

    static int dfs(int r, int c) {
        if (r == N-1 && c == M-1) {
            return 1;
        }
        if (v[r][c]) return dp[r][c];

        v[r][c] = true;
        int way = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!inRange(nr,nc)) continue;
            if (map[r][c] <= map[nr][nc]) continue;
            way += dfs(nr,nc);
        }
        dp[r][c] = way;
        return dp[r][c];
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
