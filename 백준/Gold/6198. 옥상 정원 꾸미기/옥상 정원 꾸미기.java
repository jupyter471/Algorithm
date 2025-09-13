import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] building = new int[N];

        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(building[0]);
        for (int i = 1; i < N; i++) {
            int curr = building[i];
            while (!dq.isEmpty() && dq.peekLast() <= curr) {  //같거나 높은게 들어오면 빼야됨
                dq.pollLast();
            }

            ans += dq.size();
            dq.add(curr);
        }

        System.out.println(ans);
    }
}
