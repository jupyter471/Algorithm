import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] visit;
    static boolean[] visited;
    static int order = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        ArrayList[] adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        int u,v;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(adj[i]);
        }

        visit = new int[N+1];
        visited = new boolean[N+1];
        dfs(r,adj);
        for (int i = 1; i < N+1; i++) {
            System.out.println(visit[i]);
        }
    }

    static void dfs(int r, ArrayList[] adj) {
        visit[r] = order++;
        visited[r] = true;
        for (int next : (ArrayList<Integer>) adj[r]) {
            if (!visited[next]) {
                dfs(next,adj);
            }
        }
    }
}
