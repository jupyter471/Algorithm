import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //나무 개수
        int M = Integer.parseInt(st.nextToken()); //필요한 나무 길이 M 이상이어야함

        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        //적어도 M을 가져가기 위한 높이의  최댓값 -> 최소 M
        //이진탐색?
        //초기 최대값 : 젤 높은 나무 높이
        //초기 최소값 : 0
        int min  = 0;
        //높이를 높이면 나무 줄어듦, 낮추면 나무 늘어남
        //찾아야하는 값 : M -> 최소로 나무 나오는 높이, 결과가 M보다 같거나 크고 M과의 차이가 이전 값보다 작아야함
        while (min < max) {
            int h = (min + max) / 2;
//            System.out.println(h);
            long sum = 0;
            for (int t : tree) {
                sum += (t > h ? t - h : 0);
            }

            if (sum < M) {
                max = h;  //upper bound
            }
            else {
                min = h + 1;
            }
        }

        System.out.println(min-1);



    }
}
