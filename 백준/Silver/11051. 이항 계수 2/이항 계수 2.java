import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		BigInteger[][] pas = new BigInteger[N+1][K+1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= Math.min(i,K); j++) {
				if (j == 0 || j == i) {
					pas[i][j] = BigInteger.ONE;
				}
				else {
					pas[i][j] = pas[i-1][j-1].add(pas[i-1][j]);
				}
			}
		}
		
		System.out.println(pas[N][K].mod(BigInteger.valueOf(10007)));
		
	}
}