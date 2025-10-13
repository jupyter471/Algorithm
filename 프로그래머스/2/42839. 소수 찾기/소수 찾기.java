import java.util.*;

class Solution {
    static int answer;
    static Set<Integer> set;
    public int solution(String numbers) {
        answer = 0;
        set = new HashSet<>();
        char[] nums = numbers.toCharArray();
        
        for (int i = 1; i <= nums.length; i++) {
            perm(0,0,nums, new char[i],new boolean[nums.length]);
        }
        return answer;
    }
    
    static void perm(int depth, int index, char[] arr, char[] sel, boolean[] selected) {
        if (depth == sel.length) {
            //소수 판단
            StringBuilder sb = new StringBuilder();
            for (char c : sel) {
                sb.append(c);
            }
            
            
            int num = Integer.parseInt(sb.toString());
            // System.out.println(num);
            if (!set.add(num)) return;
            if (num == 0) return;
            if (num == 1) return;
            for (int i = 2; i <= Math.sqrt(num); i++) {    
                if (num % i == 0) return;
            }
            
            answer++;
            return;
        }
        
        //순열
        for (int i = 0; i < arr.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                sel[depth] = arr[i];
                perm(depth + 1, index + 1, arr, sel, selected);
                selected[i] = false;
            }
        }
    }
}