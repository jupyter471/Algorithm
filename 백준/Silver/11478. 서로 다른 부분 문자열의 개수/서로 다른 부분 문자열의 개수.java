import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Set<String> set;
    static String str;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        set = new HashSet<>();
        N = str.length();

        int start = 0;
        int end = 0;

        //슬라이딩윈도우 N번
        for (int i = 1; i <= N; i++) {  //크기
            for (int j = 0; j < N; j++) {  //시작점
                sb = new StringBuilder();
                for (int k = j; k < i; k++) {
                    sb.append(str.charAt(k));
                }
//                System.out.println(sb);
                set.add(sb.toString());
            }
        }
        System.out.println(set.size() -1);
    }
}
