import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();
		
		int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
		
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				for (int k = 0; k <= s3.length(); k++) {
					if (i == 0 || j == 0 || k == 0) {
						dp[i][j][k] = 0;
						continue;
					}
					
					if (s1.charAt(i-1) == s2.charAt(j-1) && s2.charAt(j-1) == s3.charAt(k-1)) {
						dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
					}
					else {
						int max = Math.max(dp[i-1][j][k], dp[i][j-1][k]);
						max = Math.max(max, dp[i][j][k-1]);
						dp[i][j][k] = max;
					}
				}
			}
		}
		
		System.out.println(dp[s1.length()][s2.length()][s3.length()]);
	}
}
