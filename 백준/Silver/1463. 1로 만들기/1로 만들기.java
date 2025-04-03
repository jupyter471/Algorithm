import java.util.*;
import java.io.*;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static int[] memo;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		memo = new int[N+1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[1] = 0;
		dp(N);
		//System.out.println(Arrays.toString(memo));
		System.out.println(memo[N]);
		
	
	}
	
	static int dp(int n) {
		//3으로 나누기, 1빼기, 2로 나누기
		if (n == 1) {
			return 0;
		}
		
//		//메모
		if (memo[n] < Integer.MAX_VALUE) {
			return memo[n];
		}
		
		if (n % 3 == 0) {
			memo[n] = Math.min(memo[n], dp(n/3)+1);
		}
		
		if (n % 2 == 0) {
			memo[n] = Math.min(memo[n], dp(n/2)+1);
		}
		
		memo[n] = Math.min(memo[n], dp(n-1)+1);
				//연산 다 끝남 최소 보장
//		memo[n] = temp;
		
		return memo[n];
	}
}


// [2147483647, 2147483647, 9, 8, 8, 8, 6, 6, 5, 3, 3] X
// [2147483647, 2147483647, 4, 4, 4, 4, 4, 4, 4, 4, 4]
