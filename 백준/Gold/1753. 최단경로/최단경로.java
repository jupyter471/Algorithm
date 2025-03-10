import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // 정점 개수
        int e = sc.nextInt(); // 간선 개수
        int k = sc.nextInt(); // 시작 정점

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Node(v2, w));
        }

        int[] dist = dijkstra(k, v, graph);

        for (int i = 1; i <= v; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }

        sc.close();
    }

    static int[] dijkstra(int start, int v, List<List<Node>> graph) {
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.vertex;
            int curCost = current.cost;

            if (curCost > dist[curNode]) continue;

            for (Node next : graph.get(curNode)) {
                if (dist[curNode] + next.cost < dist[next.vertex]) {
                    dist[next.vertex] = dist[curNode] + next.cost;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        return dist;
    }
}
