import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> key = new HashSet<>();

        for (int i = 0; i < N; i++) {
            key.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            Set<String> memo = new HashSet<>();
            String[] line = br.readLine().split(",");
            for (String word : line) {
                memo.add(word);
            }
            key.removeAll(memo);
            System.out.println(key.size());
        }
    }
}
