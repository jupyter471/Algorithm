import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        //System.out.println(res);
        String str = res.toString();
        int idx = str.length()-1;
        int ans = 0;
        while (true) {
            if (str.charAt(idx--) != '0') break;
            ans++;
        }

        System.out.println(ans);
    }
}
