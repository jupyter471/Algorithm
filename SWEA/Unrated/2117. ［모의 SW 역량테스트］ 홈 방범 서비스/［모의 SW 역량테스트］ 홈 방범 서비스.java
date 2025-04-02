import java.util.*;
import java.io.*;

public class Solution {
	static int[][] map;
	static int N,M;
	static Deque<int[]> dq;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//각 위치별로 길이
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 1; k <= N+1; k++) {
						bfs(i,j,k);
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,ans);
		}
	}
	
	
	static void bfs(int i, int j, int k) {
		dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		visited[i][j] = true;
		dq.add(new int[] {i,j});
		
		int temp = 0;
		
		int cost = k * k + (k-1) * (k-1);
		//System.out.println(cost);
		if (map[i][j] == 1) {
			temp++;
		}
		
		while (k > 1) {
			int length = dq.size();
			for (int p = 0; p < length; p++) {
				int[] curr = dq.poll();
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					
					if (inRange(nr,nc) && !visited[nr][nc]) {
						if (map[nr][nc] == 1) {
							temp++;
						}
						visited[nr][nc] = true;
						dq.add(new int[] {nr,nc});
					}
 				}
			}
			k--;
		}
		 
		if (M * temp - cost >= 0) {
			//손해안봄
			//System.out.println(temp + "," + cost);
			ans = Math.max(ans, temp);
		}
	}
	
	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}
