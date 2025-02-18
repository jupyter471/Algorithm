import java.util.*;

import java.io.*;

public class Solution {
	static int N;
	static boolean[][] adjMatIn;
	static boolean[][] adjMatOut;

	static int[] inList;
	static int[] outList;
	
	//bfs 거꿇호
	//들어온 수와 나가는 수의 합이 (N-1)이면 자기 순서 아는거
	//in, out 둘다 세ㅔ애됨
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			//인접리스트 초기화
			adjMatIn = new boolean[N+1][N+1];  //1부터 시작
			adjMatOut = new boolean[N+1][N+1];  //1부터 시작
			
			
			int M = Integer.parseInt(br.readLine());

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatOut[a][b] = true;
				adjMatIn[b][a] = true;
			}			
			
			inList = new int[N+1];
			outList = new int[N+1];
			//adjMat 
			for (int i = 1; i <= N; i++) {  //노드
				Deque<Integer> dq = new ArrayDeque<>();
				boolean[] visited = new boolean[N+1];
				dq.add(i);
				while (!dq.isEmpty()) {
					int curr = dq.poll();  //탐색 시작할 노드
					visited[curr] = true;
					//curr -> c
					for (int c = 1; c <= N; c++) {//인접행렬 순회
						if (adjMatIn[curr][c] && !visited[c]) {
							//연결되어있음
							inList[i]++;
							visited[c] = true;
							dq.add(c);
						}
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {  //노드
				Deque<Integer> dq = new ArrayDeque<>();
				boolean[] visited = new boolean[N+1];
				dq.add(i);
				while (!dq.isEmpty()) {
					int curr = dq.poll();  //탐색 시작할 노드
					visited[curr] = true;
					//curr -> c
					for (int c = 1; c <= N; c++) {//인접행렬 순회
						if (adjMatOut[curr][c] && !visited[c]) {
							//연결되어있음
							outList[i]++;
							visited[c] = true;
							dq.add(c);
						}
					}
				}
			}
			
			//System.out.println(Arrays.toString(inList));
			//System.out.println(Arrays.toString(outList));
			
			int result = 0;
			for (int i = 1; i <= N; i++) {
				if ((inList[i] + outList[i]) == (N-1)) {
					result++;
				}
			}
			System.out.printf("#%d %d\n",t,result);
		}
	}
}