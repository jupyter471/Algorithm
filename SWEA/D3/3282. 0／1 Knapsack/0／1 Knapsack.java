import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] weight = new int[N+1];
			int[] value = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				weight[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}
			
			
			int[][] dp = new int[N+1][K+1];
			
			for (int i = 1; i <= N; i++) {
				for (int w = 1; w <= K; w++) {
					if (weight[i] <= w) {
						//현재 물건의 무게가 가방 보다 작음
						dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i]);
					}
					else {
						dp[i][w] = dp[i-1][w];
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, dp[N][K]);
		}
	}
}
