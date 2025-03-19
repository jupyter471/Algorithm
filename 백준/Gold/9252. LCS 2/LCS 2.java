import java.util.*;
import java.io.*;

public class Main {
    static String shorter, longer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        if (s1.length() < s2.length()) {
            shorter = s1;
            longer = s2;
        }
        else {
            shorter = s2;
            longer = s1;
        }

        int[][] dp = new int[longer.length()+1][shorter.length()+1];

        for (int i = 0; i <= longer.length(); i++) {
            for (int j = 0; j <= shorter.length(); j++) {
                if (i == 0 || j == 0) {
                    continue;
                }

                if (longer.charAt(i-1) == shorter.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[longer.length()][shorter.length()]);

        if (dp[longer.length()][shorter.length()] == 0) {
            return;
        }


        StringBuilder sb = new StringBuilder();

        int r = longer.length();
        int c = shorter.length();


        while (r > 0 && c > 0) {
            if (longer.charAt(r-1) == shorter.charAt(c-1)) {
                //같음
                sb.append(longer.charAt(r-1));
                r--;
                c--;
            }
            else if (dp[r-1][c] >= dp[r][c-1]) {
                //더 긴 LCS 선택
                r--;
            } else {
                c--;
            }

        }
        System.out.println(sb.reverse());
    }
}
