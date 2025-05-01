import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> dq = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                //stack에서 빼야됨
                if (dq.isEmpty()) return false;
                dq.pollLast();
            }
            else {
                dq.add(s.charAt(i));
            }
        }
        if (!dq.isEmpty()) return false;

        return answer;
    }
}