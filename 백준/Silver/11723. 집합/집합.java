import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //1부터 20
        int mask = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num;
            switch (cmd) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    mask = mask | 1 << (num-1);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    mask &= ~(1 << (num-1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if ((mask & (1 << (num-1))) == 0) {
                        bw.write("0");
                        bw.write("\n");
                    }
                    else {
                        bw.write("1");
                        bw.write("\n");
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    mask ^= (1 << (num-1));
                    break;
                case "all":
                    mask = (1 << 20) -1;
                    break;
                case "empty":
                    mask = 0;
                    break;
            }
        }
        bw.flush();
    }
}
