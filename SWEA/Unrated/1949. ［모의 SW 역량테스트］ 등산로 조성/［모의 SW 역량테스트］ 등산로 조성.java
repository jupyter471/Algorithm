import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int K; //최대 깊이
    static int result;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int max = 0;
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j] = temp;
                    if (temp > max) {
                        max = temp;
                    }
                }
            }

            //max 봉우리 찾기
            ArrayList<int[]> maxHill = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) {
                        maxHill.add(new int[] {i,j});
                    }
                }
            }

            for (int[] hill : maxHill) {
                visited[hill[0]][hill[1]] = true;
                dfs(hill[0], hill[1], max, 1,false);
                visited[hill[0]][hill[1]] = false;

            }
            System.out.printf("#%d %d\n",t,result);
        }
    }

    static void dfs(int r, int c, int prev, int cnt, boolean flag) {
        result = Math.max(result, cnt);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            //못 감
            if (!inRange(nr,nc) || visited[nr][nc]) continue;

            //안깎는경우
            if (prev > map[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr,nc,map[nr][nc],cnt + 1, flag);
                visited[nr][nc] = false;
            }

            //깎는경우
            else if (!flag && map[nr][nc] >= prev) {
                for (int i = 1; i <= K; i++) {
                    if (map[nr][nc] - i < prev) {
                        visited[nr][nc] = true;
                        dfs(nr,nc,map[nr][nc] - i,cnt + 1, true);
                        visited[nr][nc] = false;
                    }
                }
            }
        }
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
