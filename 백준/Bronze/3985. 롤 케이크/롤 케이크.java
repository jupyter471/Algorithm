import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int mem = Integer.parseInt(br.readLine());
		
		int[] cake = new int[len+1];
		Arrays.fill(cake, -1);
		
		int[] cnt = new int[mem+1];
		
		int expect_max = -1;
		int expect_mem = -1;
		
		for (int i = 1; i <= mem; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if (k-p > expect_max) {
				expect_max = k-p;
				expect_mem = i;
			}
			
			for (int j = p; j <= k; j++) {
				if (cake[j] == -1) {
					cake[j] = i;
					cnt[i]++;
				}
			}
		}
		
		
		int max = -1;
		int max_mem = -1;
		
		for (int i = 1; i<=mem;i++) {
			if (max < cnt[i]) {
				max = cnt[i];
				max_mem = i;
			}
		}
		
		System.out.println(expect_mem);
		System.out.println(max_mem);
	}
}
