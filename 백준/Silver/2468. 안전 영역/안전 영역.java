import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    static int N;
    static int[][] map;
    static int result = 1;  //비가 안 올 때
    public static void main(String[] args) throws Exception {
        //높이 이하 잠김 (높이 포함)
        //치즈랑 비슷한듯
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        //모든 비의 양에 대해 따져봐야됨
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //비에 따라 bfs 반복
        for (int i =1; i <= 100; i++) {
            int res = bfs(i);
            if (res == 0) {
                break;
            }
            result = Math.max(result,res);
        }
        System.out.println(result);
    }

    static int bfs(int rain) {
        int temp = 0;

        Deque<Point> dq = new ArrayDeque<>();
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dq.clear();
                if (!visited[i][j] && map[i][j] > rain) {
                    dq.add(new Point(i,j));
                    temp += 1;
                    while (!dq.isEmpty()) {
                        Point p = dq.pollFirst();
                        for (int k =0 ; k <4;k++) {
                            int nr = p.x + dr[k];
                            int nc = p.y + dc[k];
                            if (inRange(nr,nc) &&!visited[nr][nc] && map[nr][nc] > rain) {
                                dq.add(new Point(nr,nc));
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        return temp;
    }

    static boolean inRange(int r, int c) {
        return 0<= r && r < N && 0 <= c && c < N;
    }
}
