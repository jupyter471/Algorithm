import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static int N;
    static String min,max;
    static String[] strs;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strs = br.readLine().split(" ");
        //System.out.println(strs.length);
        //0부터 9까지
        min = "9999999999";
        max = "0";
        perm(0,0,new int[N+1],new boolean[10]);

        System.out.println(max);
        System.out.println(min);
    }

    static void perm(int depth, int idx, int[] sel, boolean[] visited) {
        if (depth == sel.length) {
            //부등호 유효 검사
            //최소 최대 갱신
            String result = IntStream.of(sel)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining());

            if (result.compareTo(min) < 0) min = result;
            if (result.compareTo(max) > 0) max = result ;
            return;
        }

        if (idx == 10) return;

        //여기서 가지치기 해주기!!!
        for (int i = 0; i < 10; i++) {
            if (depth == 0 || isValid(sel[depth-1],i,strs[depth-1].charAt(0)) && !visited[i]) {
                sel[depth] = i;
                visited[i] = true;
                perm(depth+1,i,sel,visited);
                visited[i] = false;
            }
        }
    }

    static boolean isValid(int a, int b, char sign) {
        return (sign == '<') ? (a<b) : (a>b);
    }
}
