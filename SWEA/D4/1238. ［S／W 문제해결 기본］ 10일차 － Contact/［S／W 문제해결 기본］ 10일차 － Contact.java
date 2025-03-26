import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            Map<Integer,ArrayList<Integer>> adjList = new HashMap();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (!adjList.containsKey(from)) {
                    adjList.put(from, new ArrayList<>());
                }
                adjList.get(from).add(to);
            }

            Deque<Integer> pq = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();

            pq.add(start);
            visited.add(start);

            ArrayList<Integer> res = new ArrayList<>();
            while (!pq.isEmpty()) {
                int size = pq.size();
                res.clear();
                for (int s = 0; s < size; s++) {
                    int curr = pq.poll();
                    res.add(curr);
                    if (adjList.containsKey(curr)) {
                        for (int i : adjList.get(curr)) {
                            if (visited.add(i)) {
                                pq.add(i);
                            }
                        }
                    }
                }
            }

            int max = 0;
            for (int i : res) {
                if (i > max) max = i;
            }
            System.out.printf("#%d %d\n",t,max);
        }
    }
}
