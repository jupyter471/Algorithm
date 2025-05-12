import java.util.*;
import java.io.*;

public class Main {
	static long answer; static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//조합
		answer = 0;
		comb(0,0,new int[2]);
		System.out.println(answer * 2);
	}
	
	static void comb(int depth, int idx, int[] sel) {
		if (depth == 2) {
			answer += Math.abs(sel[1] - sel[0]);
			return;
		}
		
		if (idx == N) return;
		
		//뽑거나
		sel[depth] = arr[idx];
		comb(depth + 1, idx + 1, sel);
		//안뽑거나
		comb(depth, idx + 1, sel);
	}
}