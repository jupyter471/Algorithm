import java.io.*;
import java.util.*;

public class Main {
    //10의 배수인거 먼저 자름
    static class Cake implements Comparable<Cake> {
        int len;

        public Cake(int len) {
            this.len = len;
        }
        @Override
        public int compareTo(Cake o) {
            return Integer.compare(this.len % 10, o.len % 10);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt((Integer num) -> num % 10)
                        .thenComparingInt(num -> num));

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int len = Integer.parseInt(st.nextToken());
            if (len > 10) {
                pq.add(len);
            }

            if (len == 10) ans++;
        }

        while (M > 0 && !pq.isEmpty()){
            int len = pq.poll();
//            System.out.printf("%d %d\n",len,ans);

            //자르기
            if (len - 10 == 10) {
                //자르고 남은게 10
                ans++;
            }
            if (len - 10 > 10) {
                pq.add(len - 10); //자르고 넣기
            }

            ans++;
            M--;
        }

        System.out.println(ans);
    }
}
