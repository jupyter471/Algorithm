import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int first = Integer.MAX_VALUE;
            int second = -1;

            Deque<Integer>[] index = new ArrayDeque[26];
            for (int i = 0; i < 26; i++) {
                index[i] = new ArrayDeque<>();
            }

            for (int i = 0; i < input.length(); i++) {
                int curr = input.charAt(i) - 'a';
                index[curr].add(i);

                if (index[curr].size() == K) {
                    first = Math.min(first,index[curr].getLast() - index[curr].getFirst()+1);
                    second = Math.max(second, index[curr].getLast() - index[curr].getFirst() + 1);
                    index[curr].pollFirst();
                }
            }

            if (first == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
                continue;
            }
            else {
                sb.append(first).append(" ");
            }

            sb.append(second).append("\n");
        }
        System.out.println(sb);
    }
}
