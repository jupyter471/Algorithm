import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static int[] line;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        line = new int[K];
        long top = 0;
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            top = Math.max(top, line[i]);
        }

        long bottom = 1;
        while (bottom <= top) {
            long middle = (bottom + top) / 2;
            if (isPossible(middle)) {
                //일단 가능 더 길게
                bottom = middle + 1;
            }

            else {
                top = middle - 1;
            }
        }
        System.out.println(top);

    }

    public static boolean isPossible(long middle) {
        int cnt = 0;
        if (cnt >= N) return true;
        for (int i = 0; i < K; i++) {
            cnt += (line[i] / middle);
        }

        return cnt >= N;

    }
}
