import com.sun.source.tree.Tree;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        TreeSet<Integer> s1 = mod(n1);
        TreeSet<Integer> s2 = mod(n2);
//        System.out.println(s1);

        TreeSet<Integer> inter = new TreeSet<>(s1);
        inter.retainAll(s2);
        int max = inter.last();  //최대공약수
        int min = (n1 / max) * (n2 / max) * max;
        System.out.println(max);
        System.out.println(min);
    }

    static TreeSet<Integer> mod(int num) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                s.add(i);
                if (i != num / i) {
                    //제곱이 아닐 때
                    s.add(num / i);
                }
            }
        }
        return s;
    }
}
