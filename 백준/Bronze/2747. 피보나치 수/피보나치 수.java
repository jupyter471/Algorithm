import java.util.*;
import java.io.*;

public class Main {
    static long[] memo;
    
    static long fibo(int n) {
        if (n < 2) return n;
        if (memo[n] != -1) return memo[n];
        else {
            return memo[n] = fibo(n-1)  + fibo(n-2);
        }
    } 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        memo = new long[N+1];
        Arrays.fill(memo, -1);
        System.out.println(fibo(N));
    }
}