import java.util.*;
import java.io.*;

public class Solution {
	static int[][] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			adj = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(adj[i], 1001);
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Integer.parseInt(st.nextToken()) > 0) {
						adj[i][j] = 1;
					}
				}
				adj[i][i] = 0;
				//System.out.println(Arrays.toString(adj[i]));
			}
			
			
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += adj[i][j];
				}
				min = Math.min(min, sum);
			}
			
			System.out.printf("#%d %d\n",t,min);
		}
	}
}
