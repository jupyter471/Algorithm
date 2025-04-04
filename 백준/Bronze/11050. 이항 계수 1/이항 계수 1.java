import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] pas = new int[N+1][K+1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= Math.min(i,K); j++) {
				if (j == 0 || j == i) {
					pas[i][j] = 1;
				}
				else {
					pas[i][j] = pas[i-1][j-1] + pas[i-1][j];
				}
			}
		}
		
		System.out.println(pas[N][K]);
		
	}
}


/*
 * nCk = n-1Ck-1 + n-1Ck
 * */