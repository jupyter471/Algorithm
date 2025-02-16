import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  //원판개수

        BigInteger cnt = BigInteger.TWO.pow(n).subtract(BigInteger.ONE);
        System.out.println(cnt);
        if (n > 20) {
            return;
        }
        hanoi(n,1,2,3);
        System.out.println(sb);

    }

    static void hanoi(int n, int from, int temp, int to) {
        if (n == 0) {
            return;
        }
        //n개를 3번쨰로 옮기려면(to)
        //n-1개를 2번째로 옮기고(temp)
        //n번쨰를 3번째 장대로(to)
        //n-1개를 3번째 장대로(to)

        //A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
        hanoi(n-1,from,to,temp);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n-1,temp,from,to);
    }
}
