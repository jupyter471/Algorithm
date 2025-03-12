import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v, c;

        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.c, n.c);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 정점 개수
        int e = Integer.parseInt(st.nextToken()); // 간선 개수

        int k = Integer.parseInt(br.readLine()); // 시작 정점

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v2, w));
        }

        int[] dist = dijkstra(k, v, graph);

        for (int i = 1; i <= v; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    static int[] dijkstra(int start, int v, List<List<Node>> graph) {
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.v;
            int curCost = current.c;

            if (curCost > dist[curNode]) continue;

            for (Node next : graph.get(curNode)) {
                if (dist[curNode] + next.c < dist[next.v]) {
                    dist[next.v] = dist[curNode] + next.c;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }
}

