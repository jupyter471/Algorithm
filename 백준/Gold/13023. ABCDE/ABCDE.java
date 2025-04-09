import java.util.*;
import java.io.*;

public class Main {
	static ArrayList[] frnd;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		frnd = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			frnd[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			frnd[a].add(b);
			frnd[b].add(a);
		}
		
		boolean[] v = new boolean[N];
		for (int i = 0; i < N; i++) {
			v[i] = true;
			dfs(i, v,0);
			v[i] = false;
		}
		System.out.println(0);
	}
	
	static void dfs(int i, boolean[] v, int cnt) {
		//
//		System.out.println(i + " ,"+ cnt);
		if (cnt == 4) {
			System.out.println(1);
			System.exit(0);
		}
		//
		for (int j = 0; j < frnd[i].size(); j++) {
			int idx = (int) frnd[i].get(j);
			if (!v[idx]) {
				v[idx] = true;
				dfs(idx,v,cnt+1);
				v[idx] = false;
			}
		}
	}
}
