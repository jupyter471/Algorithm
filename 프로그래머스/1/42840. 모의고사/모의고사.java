import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[][] omr = {
            {1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}
        };
        
        int one = 0;
        int two = 0;
        int three = 0;
        int[] score = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == omr[0][i % omr[0].length]) score[0]++;
            if (answers[i] == omr[1][i % omr[1].length]) score[1]++;
            if (answers[i] == omr[2][i % omr[2].length]) score[2]++;
        }
        
        int max = -1;
        
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, score[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (score[i] == max) {
                ans.add(i+1);
            }
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}