import java.util.*;

class Solution {
    static int[] win;
    static int[] lose;
    public int solution(int n, int[][] results) {
        int answer = 0;
        //정확하게 순위를 매길 수 있는 선수 수 리턴
        //bfs 두번
        
        //[A,B] -> A > B
        win = new int[n+1];
        lose = new int[n+1];
        
        ArrayList[] winlist = new ArrayList[n+1]; //해당 인덱스 선수가 이긴 선수
        ArrayList[] loselist = new ArrayList[n+1]; //해당 인덱스 선수가 진 선수
        
        for (int i = 0; i < n+1; i++) {
            winlist[i] = new ArrayList<>();
            loselist[i] = new ArrayList<>();
        }
        
        for (int[] r : results) {
            winlist[r[0]].add(r[1]);
            loselist[r[1]].add(r[0]);
        }
        
        Deque<Integer> dq;
        //BFS N번
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n+1];
            dq = new ArrayDeque<>();
            dq.add(i);
            visited[i] = true;
            while (!dq.isEmpty()) {
                int c = dq.poll();
                for (int next : (ArrayList<Integer>) winlist[c]) {
                    if (!visited[next]) {
                        dq.add(next);
                        win[i]++;
                        visited[next] = true;
                    }
                }
            }   
        }
        
        //BFS N번
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n+1];
            dq = new ArrayDeque<>();
            dq.add(i);
            visited[i] = true;

            while (!dq.isEmpty()) {
                int c = dq.poll();
                for (int next : (ArrayList<Integer>) loselist[c]) {
                    if (!visited[next]) {
                        dq.add(next);
                        lose[i]++;
                        visited[next] = true;
                    }
                }
            }   
        }
        
//         System.out.println(Arrays.toString(win));
    
        
//         System.out.println(Arrays.toString(lose));
        
        for (int i = 1; i <= n; i++) {
            if (win[i] + lose[i] == n-1) answer++;
        }
        return answer; 
    }
    
}