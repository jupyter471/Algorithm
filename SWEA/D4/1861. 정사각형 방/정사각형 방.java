import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int[][] map;
    static int[][] memo;
    static int ans, room;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            memo = new int[N][N];

            //시작
            int r = 0;
            int c = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = 0;
            room = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int count = move(i,j);
                    if (count > ans || (ans == count && room > map[i][j])) {
                        ans = count;
                        room = map[i][j];
                    }
                }
            }
            System.out.println("#" + t + " " + room + " " + ans);
        }
    }

    static int move(int r, int c) {
        if (memo[r][c] != 0) return memo[r][c]; //이전에 계산하여 기록함
        memo[r][c] = 1;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (inRange(nr,nc) && map[nr][nc] - map[r][c]== 1) {
                memo[r][c] = Math.max(memo[r][c], move(nr,nc) + 1);
            }
        }
        return memo[r][c];
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0<=c && c < N;
    }
}
