import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    static ArrayList<ArrayList<Node>> adjList;
    static ArrayList<ArrayList<Node>> rev;
    static int N;
    static int[] in, out;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //왔다갔다 왕복
        adjList = new ArrayList<ArrayList<Node>>();
        rev = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<Node>());
            rev.add(new ArrayList<Node>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(v).add(new Node(u,cost));
            rev.get(u).add(new Node(v,cost));
        }



        //다익스트라
        // 각 집에서 -> X
        //x -> 각 집

        in = dik(adjList, X);
        out = dik(rev, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            if (in[i] + out[i] > max) {
                max = in[i] + out[i];
            }
        }

        System.out.println(max);

    }

    static int[] dik(ArrayList<ArrayList<Node>> adj, int start) {
        int[] dist = new int[N+1];
        boolean[] v = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> dq = new PriorityQueue<>();
        dq.add(new Node(start, 0));

        while (!dq.isEmpty()) {
            Node curr = dq.poll();
            if (v[curr.to]) continue;
            v[curr.to] = true;
            for (int i = 0; i < adj.get(curr.to).size(); i++) {
                if (dist[curr.to] + adj.get(curr.to).get(i).cost < dist[adj.get(curr.to).get(i).to]) {
                    dist[adj.get(curr.to).get(i).to] = dist[curr.to] + adj.get(curr.to).get(i).cost;
                    dq.add(new Node(adj.get(curr.to).get(i).to, dist[curr.to] + adj.get(curr.to).get(i).cost));
                }
            }
        }

        return dist;
    }
}