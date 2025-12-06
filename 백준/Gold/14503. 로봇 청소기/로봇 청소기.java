import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] dr,dc;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cr = Integer.parseInt(st.nextToken());
        int cc = Integer.parseInt(st.nextToken());
        int cdir = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //반시계 방향
        HashMap<Integer, int[]> dirmap = new HashMap<>();
        dirmap.put(0, new int[]{-1,0});
        dirmap.put(1, new int[] {0,1});
        dirmap.put(2, new int[] {1,0});
        dirmap.put(3, new int[] {0,-1});

        //상 좌 하 우 0 1 2 3
        //상 좌 하 우
        dr = new int[]{-1,0,1,0};
        dc = new int[]{0,1,0,-1};

        int ans = 0;
        while (true) {
            //현재 칸 청소 X
            if (map[cr][cc] == 0) {
                map[cr][cc] = 2;
                ans++;
            }

            //주변 4칸 확인
            if (check(cr, cc)) {
                for (int i = 0; i < 4; i++) {
                    cdir = (cdir + 3) % 4;
                    //반시계 90도 회전
                    int nr = cr + dirmap.get(cdir)[0];
                    int nc = cc + dirmap.get(cdir)[1];

                    if (inRange(nr,nc) && map[nr][nc] == 0) {
                        cr = nr;
                        cc = nc;
                        break;
                    }
                }
            }

            else {
                //후진
                int nr = cr - dirmap.get(cdir)[0];
                int nc = cc - dirmap.get(cdir)[1];
                if (inRange(nr,nc) && map[nr][nc] != 1) {
                    cr = nr;
                    cc = nc;
                }
                else {
                    System.out.println(ans);
                    break;
                }
            }
        }
    }

    static boolean check(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (inRange(nr,nc) && map[nr][nc] == 0) return true;
        }
        return false;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
