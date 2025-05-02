import java.util.*;

class Solution {
    static int n,m;
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        int v[][] = new int[n][m];
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {0,0});
        
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            if (curr[0] == n-1 && curr[1] == m-1) return v[n-1][m-1] + 1;
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                if (inRange(nr,nc) && maps[nr][nc] == 1 && v[nr][nc] == 0) {
                    v[nr][nc] = v[curr[0]][curr[1]] + 1;
                    dq.add(new int[] {nr,nc});
                }
            }
        }
        
        return v[n-1][m-1] == 0 ? -1 : v[n-1][m-1] + 1;
    }
    
    static boolean inRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}