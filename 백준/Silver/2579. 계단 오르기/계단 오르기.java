import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] step = new int[N];
		for (int i = 0; i < N; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N];
		
		
		if (N == 1) {
			System.out.println(step[0]);
			return;
		}
		
		if (N == 2) {
			System.out.println(step[0] + step[1]);
			return;
		}
		dp[0] = step[0];
		dp[1] = step[0] + step[1];
		dp[2] = Math.max(dp[0], step[1]) + step[2];
		
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i-2], step[i-1] + dp[i-3]) + step[i];
		}
		
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[N-1]);
	}
}