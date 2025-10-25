import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M;
    static int[][] map;
    static int task;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        Deque<int[]> dq = new ArrayDeque<>();
        task = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    dq.add(new int[] {i,j});
                }
                if (map[i][j] == 0) task++;
            }
        }

        if (task == 0) {
            System.out.println(0);
            return;
        }

        int day = 0;
        boolean[][] visited = new boolean[N][M];

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.pollFirst();
                if (visited[curr[0]][curr[1]]) continue;
                visited[curr[0]][curr[1]] = true;
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];

                    if (!inRange(nr,nc)) continue;
                    if (map[nr][nc] == 1 || map[nr][nc] == -1) continue;
                    if (visited[nr][nc]) continue;
                    map[nr][nc] = 1;
                    task--;
                    dq.add(new int[] {nr,nc});
                }
            }
            day++;
        }

        if (task == 0) {
            System.out.println(day-1);
        }
        else {
            System.out.println(-1);
        }


    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
