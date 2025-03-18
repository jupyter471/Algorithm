import java.util.*;
import java.io.*;

public class Main {
    static int mid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        //이분탐색
        int start = 1;
        int end = house[N-1] - house[0];

        while (start <= end) {
            mid = (start + end) / 2;

            //mid로 집에 다 설치 가능한지 확인
            int last = house[0];
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (last + mid <= house[i]) {
                    last = house[i];
                    cnt += 1;
                }
            }

            if (cnt < C) {
                //거리 좁혀야됨
                end = mid - 1;
            }
            else {
                //거리 넓히기
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}
