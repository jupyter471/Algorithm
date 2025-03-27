import java.util.*;
import java.io.*;

public class Solution {
    static ArrayList<int[]> ppl;
    static ArrayList<int[]> stairs;
    static Queue[] steps;
    static int pplc;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //총 시간 = 입구까지 + 내려가는 시간
        //사람 위치 - 계단 위치
        //1분후 아래로 내려갈 수 있음
        //3명까지 계단 가능
        //K길이 -> K분

        //계단은 반드시 2개임

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 1; t <= T; t++) {
            ans = Integer.MAX_VALUE;
            ppl = new ArrayList<>();
            stairs = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());

            //초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        ppl.add(new int[] {i,j});
                    }

                    if (num > 1) {
                        stairs.add(new int[] {i,j,num});
                    }
                }
            }

            pplc = ppl.size();
            //두 그룹으로 뽑고 시뮬레이션
            divide(new boolean[pplc],0);

            System.out.printf("#%d %d\n",t,ans);
        }
    }


    static void divide(boolean[] v, int idx) {
        if (idx == pplc) {
            //카운트
            simul(v);
            return;
        }


        v[idx] = true;
        divide(v,idx+1);

        v[idx] = false;
        divide(v,idx+1);
    }


    static void simul(boolean[] v) {

        //계단까지 거리 구하기
        ArrayList[] way = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            way[i] = new ArrayList<>();
        }

        for (int i = 0; i < pplc; i++) {
            if (v[i]) {
                //0번째 계단
                //계단까지 가는 시간
                way[0].add(Math.abs(ppl.get(i)[0] -  stairs.get(0)[0]) + Math.abs(ppl.get(i)[1] - stairs.get(0)[1]));
            }
            else {
                way[1].add(Math.abs(ppl.get(i)[0] -  stairs.get(1)[0]) + Math.abs(ppl.get(i)[1] - stairs.get(1)[1]));

            }
        }

        //0그룹 이동
        int t1 = move(way[0], stairs.get(0)[2]);
        //1그룹 이동
        int t2 = move(way[1], stairs.get(1)[2]);

        ans = Math.min(ans, Math.max(t1,t2));

    }

    static int move(ArrayList<Integer> arrive, int length) {
        Collections.sort(arrive);  //가장 빨리 도착하는 놈 먼저 계단 내려가야됨

        ArrayList<Integer> wait = new ArrayList<>(arrive);  //계단 위에서 대기 중
        ArrayList<Integer> inUse = new ArrayList<>();

        int end = 0;  //다 내려간 사람

        int currTime = 0;

        while (end < arrive.size()) {
            //계단 내려가는 중
            for (int i = 0; i < inUse.size(); i++) {
                if (inUse.get(i) <= currTime) {
                    inUse.remove(i);
                    i--;
                    end++;
                }
            }

            //계단 대기자
            while (!wait.isEmpty() && wait.get(0) <= currTime && inUse.size() < 3) {
                inUse.add(Math.max(currTime, wait.get(0)) + length);
                wait.remove(0);
            }
            currTime++;
        }
        return currTime;
    }
}
