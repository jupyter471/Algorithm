import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[b];

        int cnt = 1;
        int start = 1;
        int idx = 0;
        while (idx < b) {
            for (int i = 0; i < cnt; i++) {
                if (idx >= b) break;
                arr[idx++] = start;
            }
            cnt++;
            start++;
        }

//        System.out.println(Arrays.toString(arr));
        int ans = 0;
        for (int i = a-1; i < b; i++) {
            ans += arr[i];
        }
        System.out.println(ans);
    }
}
