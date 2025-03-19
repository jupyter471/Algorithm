import java.util.*;
import java.io.*;

public class Main {
    static int time;
    static int ans;
    static int[] freq;
    static int N,M,B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        freq = new int[257];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                freq[Integer.parseInt(st.nextToken())]++;
            }
        }

        time = Integer.MAX_VALUE;
        ans = -1;
        for (int i = 256; i >= 0; i--) {
            trim(i);
        }
        System.out.printf("%d %d\n",time,ans);
    }

    static void trim(int target) {
        int t = 0;
        int add = 0; //새로 쌓아야하는 블록
        int sub = B; //인벤토리 블록 개수
        for (int i = 0; i < 257; i++) {
            if (target > i) {
                //더해야함
                add += (target - i) * freq[i];
                t += (target - i) * freq[i];
            }
            else if (target < i) {
                //깎아야함
                sub += (i - target) * freq[i];
                t += (i - target) * freq[i] * 2;
            }
        }
        if (sub >= add)  {
            if (t < time) {
                time = t;
                ans = target;
            }
        }
    }
}
