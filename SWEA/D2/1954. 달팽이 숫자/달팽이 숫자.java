import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] snail = new int[N][N];

            //우 하 좌 상
            int[] dr = new int[] {0,1,0,-1};
            int[] dc = new int[] {1,0,-1,0};
            int num = 1;
            int r = 0;
            int c = 0;
            int d = 0;
            snail[r][c] = num++;
            while (num <= N*N) {
                r = r + dr[(d % 4)];
                c = c + dc[(d % 4)];
                if (!inRange(r,c,N) || snail[r][c] > 0) {
                    r -= dr[(d % 4)];
                    c -= dc[(d % 4)];
                    d++;
                    continue;
                }
                snail[r][c] = num;
                num++;
            }

            System.out.printf("#%d\n",t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%d ",snail[i][j]);
                }
                System.out.println();
            }

        }

    }

    static boolean inRange(int r, int c, int N) {
        return 0<=r && r < N && 0 <= c && c < N;
    }
}
