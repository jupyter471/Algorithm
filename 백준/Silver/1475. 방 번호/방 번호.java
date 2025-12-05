import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 6 -> 9, 9 -> 6
        //0 - 9
        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        int answer = 0;
        char[] nums = num.toCharArray();
        int[] used = new int[10];

        for (char n : nums) {
            int x = n - '0';
            if (used[x] == 0) {
                if (x == 6 && used[9] > 0) {
                    used[9]--;
                    continue;
                }
                if (x == 9 && used[6] > 0) {
                    used[6]--;
                    continue;
                }
                for (int i = 0; i < 10; i++) {
                    used[i] += 1;
                }
                answer += 1;
            }
            used[x]--;
        }

        System.out.println(answer);
    }
}
