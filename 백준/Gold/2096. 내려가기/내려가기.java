import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int MIN, MAX;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] line = new int[3];

        //초기화
        int[] max = new int[3];
        int[] min = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            max[i] = num;
            min[i] = num;
        }

        //입력 받으면서 값 갱신하기
        // 0 -> 1 1 -> 0,2 2 -> 1
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int[] copyMax = Arrays.copyOf(max,3);
            int[] copyMin = Arrays.copyOf(min,3);
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());

            max[0] = Math.max(copyMax[0],copyMax[1]) + one;
            max[1] = Math.max(copyMax[0] > copyMax[1] ? copyMax[0] : copyMax[1], copyMax[2]) + two;
            max[2] = Math.max(copyMax[1], copyMax[2]) + three;

            min[0] = Math.min(copyMin[0],copyMin[1]) + one;
            min[1] = Math.min(copyMin[0] < copyMin[1] ? copyMin[0] : copyMin[1], copyMin[2]) + two;
            min[2] = Math.min(copyMin[1], copyMin[2]) + three;
        }

        MIN = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (MAX < max[i]) MAX = max[i];
            if (MIN > min[i]) MIN = min[i];
        }


        System.out.printf("%d %d\n",MAX,MIN);
    }
}
