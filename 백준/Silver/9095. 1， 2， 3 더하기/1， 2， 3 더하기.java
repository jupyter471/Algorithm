import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 11;
		//bottom - up
		int[] dp = new int[N];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i < N; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(dp[num]);
		}
	}
}