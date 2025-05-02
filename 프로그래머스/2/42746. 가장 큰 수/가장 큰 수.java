import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        //문자열 비교
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> b.compareTo(a));
        
        for (int n : numbers) {
            pq.add(String.valueOf(n));
        }
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        //System.out.println("10".compareTo("6"));
        return answer;
    }
}