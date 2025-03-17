import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N : 동기 수
		//학번 : 1 - N
		//MST 엣지 개수
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[N+1];
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}
		
		visited[1] = true;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i : adjList.get(1)) {
			dq.add(i);
		}
		
		int ans = 0;
		int level = 0;
		//친구의 친구 : 레벨 2
		while (!dq.isEmpty()) {
			if (level == 2) break;
			int length = dq.size();
			for (int i = 0; i < length; i++) {
				int curr = dq.poll();
				if (visited[curr]) continue;
//				System.out.println(curr);
				ans++;
				visited[curr] = true;
				for (int k : adjList.get(curr)) {
					if (!visited[k]) {
						dq.add(k);
					}
				}
			}
			level++;
			
		}
		System.out.println(ans);
	}

}
