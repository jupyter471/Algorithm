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
        int[] arr = new int[10];
        for (int i = 0; i <= 9; i++) {
            arr[i] = i;
        }
        //0부터 9까지
        min = "9999999999";
        max = "0";
        perm(0,0,new int[N+1],arr,new boolean[10]);

        System.out.println(max);
        System.out.println(min);
    }

    static void perm(int depth, int idx, int[] sel, int[] arr, boolean[] visited) {
        if (depth == sel.length) {
            //부등호 유효 검사
            if (check(sel)) {
                //최소 최대 갱신
                String result = IntStream.of(sel)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining());

                if (result.compareTo(min) < 0) min = result;
                if (result.compareTo(max) > 0) max = result ;
            }
            return;
        }

        if (idx == arr.length) return;

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                sel[depth] = arr[i];
                visited[i] = true;
                perm(depth+1,i,sel,arr,visited);
                visited[i] = false;
            }
        }
    }

    static boolean check(int[] sel) {
        //System.out.println(Arrays.toString(sel));
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].charAt(0) == '<') {
                // a < b
                if (sel[i] > sel[i+1]) return false;
            }
            else {
                // a > b
                if (sel[i] < sel[i+1]) return false;
            }
        }
        return true;
    }
}
