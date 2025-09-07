import java.util.*;
import java.io.*;

public class Main {
    static int[] nums;
    static boolean[] visited;
    static boolean[] finished;
    static ArrayList<Integer> ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        finished = new boolean[N+1];

        nums = new int[N+1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (int n : ans) {
            System.out.println(n);
        }
    }

    static void dfs(int index) {
        visited[index] = true;

        //다음으로 방문할 곳
        int num = nums[index];

        if (!visited[num]) {
            dfs(num);
        }

        if (!finished[num]) {
            //사이클 생김
            int x = num;
            do {
                ans.add(x);
                x = nums[x];
            } while (x != num);
        }

        finished[index] = true;
    }
}
