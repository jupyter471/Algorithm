import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> num = new TreeSet<>();
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            num.add(temp);
            arr[i] = temp;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i : num) {
            map.put(i,index++);
        }

        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(map.get(x)).append(" ");
        }

        System.out.println(sb);
    }
}
