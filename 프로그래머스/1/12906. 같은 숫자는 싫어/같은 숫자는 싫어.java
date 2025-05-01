import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                continue;
            }
            answer.add(arr[i]);
        }
        //System.out.println(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}