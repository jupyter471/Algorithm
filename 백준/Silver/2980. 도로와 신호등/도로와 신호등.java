import java.util.*;
import java.io.*;

public class Main {
    static int N,L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] road = new int[L+1];  //도로
        int info[][] = new int[N+1][3];  //D R G
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] =  Integer.parseInt(st.nextToken());
            info[i][1] =  Integer.parseInt(st.nextToken());
            info[i][2] =  Integer.parseInt(st.nextToken());
            road[info[i][0]] = i;  //도로에 신호등 정보 저장
        }

        int time = 0;  //시간
        int d = 0; //현재 이동한 거리
        while (d < L) {
            if (road[d] > 0) {
                //신호등 있음
                int r = info[road[d]][1];
                int g = info[road[d]][2];
                if ( time % (r + g) <= r) {
                    //빨간불
                    time += (r - (time % (r + g))); //대기시간
                }
                //초록불
                d++;
                time++;
            }
            else {
                //그냥 지나감
                time++;
                d++;
            }
        }
        System.out.println(time);
    }
}
