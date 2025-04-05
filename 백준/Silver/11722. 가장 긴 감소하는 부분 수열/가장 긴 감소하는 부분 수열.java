import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //부분 수열 안에 부분 수열
        int[] dp = new int[N];
        Arrays.fill(dp,1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[i]) {
                    //감소함
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int n : dp) {
            if (max < n) max = n;
        }
        System.out.println(max);
    }
}
