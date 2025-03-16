import java.util.*;
class Solution {
    static class Node implements Comparable<Node> {
        int v;
        int u;
        int cost;
        
        public Node (int v, int u, int cost) {
            this.v = v;
            this.u = u;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;

        //costs[i][0] [1] : 섬 , [2] : 비용 -> 양방향
        //최소 비용으로 모든 섬 통해 가능
        //mst
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < costs.length; i++) {
            map[costs[i][0]][costs[i][1]] = costs[i][2];
            map[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        
        boolean[] visited = new boolean[n];
        
        int src = 0;
        visited[0] = true;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            if (map[0][i] != Integer.MAX_VALUE) {
                    dist[i] = map[0][i];
                    pq.add(new Node(0,i,map[0][i]));
                }
        }
    
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited[curr.u]) continue;
            visited[curr.u] = true;
            for (int i = 0; i < n; i++) {
                if (map[curr.u][i] != Integer.MAX_VALUE && !visited[i]) {
                    if (dist[i] > map[curr.u][i]) {
                        dist[i] = map[curr.u][i];
                        pq.add(new Node(curr.u,i,map[curr.u][i]));
                    }
                }
            }
        }
        
        for (int c : dist) {
            answer += c;
        }
        
        return answer;
    }
}