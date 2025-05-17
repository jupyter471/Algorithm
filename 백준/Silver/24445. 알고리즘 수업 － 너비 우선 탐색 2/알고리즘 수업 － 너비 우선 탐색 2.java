import java.util.*;
import java.io.*;

public class Main {
    static int N,M,R;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ArrayList[] adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            adj[v].add(u);
            adj[u].add(v);
        }

        int[] num = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(R);

        int idx = 1;
        visited[R] = true;

        while (!dq.isEmpty()) {
            int c = dq.pollFirst();
            num[c] = idx++;
            Collections.sort((ArrayList<Integer>) adj[c], Collections.reverseOrder());
            for (int next : (ArrayList<Integer>)adj[c]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dq.add(next);
                }
            }
        }
        for (int i = 1; i < N+1; i++) {
            System.out.println(num[i]);
        }
    }
}
