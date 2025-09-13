import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int num = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            while (true) {
                while (dq.isEmpty() || dq.peekLast() < target) {
                    if (num > N) {
                        System.out.println("NO");
                        return;
                    }
                    sb.append("+").append("\n");

                    dq.addLast(num++);
                }

                if (dq.peekLast() == target) {
                    sb.append("-").append("\n");
                    dq.pollLast();
                    break;
                }
                else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
    }
}

