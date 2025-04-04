import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger[] dp = new BigInteger[N+1];
		
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[N].mod(BigInteger.valueOf(10007)));
	}
}
