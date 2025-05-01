import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int prev = arr[0];
        answer.add(prev);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prev) {
                continue;
            }
            answer.add(arr[i]);
            prev = arr[i];
        }
        //System.out.println(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}