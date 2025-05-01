import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int div = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] == 0) {
                dq.add(div);
            } else {
                dq.add(div + 1);
            }
        }
        //System.out.println(dq);
        
        int day = 0;
        while (!dq.isEmpty()) {
            if (dq.peekFirst() == day) {
                int temp = 0;
                while (!dq.isEmpty() && dq.peekFirst() <= day) {
                    dq.pollFirst();
                    temp++;
                }
                ans.add(temp);
            }
            day++;
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}