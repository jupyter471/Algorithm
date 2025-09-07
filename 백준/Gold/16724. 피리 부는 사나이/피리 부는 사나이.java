import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int cnt;
    static HashMap<Character, int[]> dir;
    static boolean[][] visited;
    static boolean[][] finished;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dir = new HashMap<>();
        dir.put('D', new int[] {1,0});
        dir.put('U', new int[] {-1,0});
        dir.put('L', new int[] {0,-1});
        dir.put('R', new int[] {0,1});

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
            }
        }
        visited = new boolean[N][M];
        finished = new boolean[N][M];
        //dfs 사이클 개수 판단하기
        cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && !finished[i][j]) {
                    dfs(new int[] {i,j});
                }
            }
        }


        System.out.println(cnt);
    }

    static void dfs(int[] v) {

        visited[v[0]][v[1]] = true;

        int nr = v[0] + dir.get(map[v[0]][v[1]])[0];
        int nc = v[1] + dir.get(map[v[0]][v[1]])[1];

        if (inRange(nr,nc) && !visited[nr][nc]) {
            dfs(new int[] {nr,nc});
        }

        if (visited[nr][nc] && !finished[nr][nc]) {
            cnt++;
        }

        //탐색 끝
        finished[v[0]][v[1]] = true;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

}
