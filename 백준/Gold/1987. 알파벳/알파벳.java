import java.util.*;
import java.io.*;

public class Main {
    static int R,C;
    static char[][] map;
    static int ans;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        ans = 1;
        visited = new boolean[R][C];
        visited[0][0] = true;
        HashSet<Character> set = new HashSet<>();
        set.add(map[0][0]);
        dfs(0,0,set);
        System.out.println(ans);
    }

    static void dfs(int r, int c, HashSet<Character> set) {

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (inRange(nr,nc) && set.add(map[nr][nc]) && !visited[nr][nc])  {
                ans = Math.max(ans, set.size());
                visited[nr][nc] = true;
                dfs(nr,nc,set);
                visited[nr][nc] = false;
                set.remove(map[nr][nc]);
            }
        }


    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}
