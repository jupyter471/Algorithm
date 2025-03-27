import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // H = sum % M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String target = br.readLine();

        //a : 97

        int r = 31;
        int M = 1234567891;

        int sum = 0;
        for (int i = 0; i < num; i++) {
            int s = target.charAt(i) - 96;
            sum += s * Math.pow(r,i);
        }
        System.out.println(sum % M);
    }
}
