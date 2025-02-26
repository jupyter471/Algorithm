import java.util.*;
import java.io.*;

public class Solution {
    static int N,B, ans;
    static int[] heights;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            heights = new int[N];
            st = new StringTokenizer(br.readLine());

            ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            choose(0,0);

            System.out.printf("#%d %d\n",t,ans);
        }
    }

    static void choose(int idx,int sum) {
        if(sum >= B) {
            ans = Math.min(ans, sum - B);
            return;
        }

        if (idx == N) return;

        //고르거나
        choose(idx + 1, sum + heights[idx]);

        //안고르거나
        choose(idx + 1, sum);
    }
}
