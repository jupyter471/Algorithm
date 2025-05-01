import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        HashMap<Integer, Integer> map =  new HashMap<>();

        //처음 순서 queue에 넣기
        for (int i = 0; i < priorities.length; i++) {
            dq.add(i);
            map.put(i,priorities[i]);
        }

        Arrays.sort(priorities);
        ArrayDeque<Integer> prior = new ArrayDeque<>();
        for (int i = priorities.length - 1; i >= 0; i--) {
            prior.add(priorities[i]);
        }

        int turn = 1;
        while (true) {
            int curr = dq.pollFirst();
            if (prior.peekFirst() == map.get(curr)) {
                //대기 중인 프로세스 중 우선순위 가장 높음
                
                if (curr == location) return turn;
                prior.pollFirst();
                turn++;
            }
            else {
                dq.add(curr);
            }
        }
    }
}