import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int cnt = 0;
        StringBuilder sb = new StringBuilder(input);
        while (true) {
            int sum = 0;
            if (sb.length() == 1) {
                sb.insert(0,"0");
            }
            for (int i = 0; i < sb.length(); i++) {
                sum += sb.charAt(i) - '0';
            }
            //System.out.println("sum " + sum);
            char last = sb.charAt(sb.length()-1);
            String temp = String.valueOf(sum);
            sb.setLength(0);
            sb.append(last);
            sb.append(temp.charAt(temp.length()-1));
            cnt++;
            //System.out.println(sb);
            if (Integer.valueOf(input) == Integer.valueOf(sb.toString())) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
