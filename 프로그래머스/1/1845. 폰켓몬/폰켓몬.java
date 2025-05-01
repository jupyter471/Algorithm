import java.util.*;

class Solution {
    static int ans = 0;
    public int solution(int[] nums) {
        int answer = 0;
        
        //조합으로 풀기
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        
        int pick = nums.length / 2;
        return Math.min(set.size(), pick);
    }
}