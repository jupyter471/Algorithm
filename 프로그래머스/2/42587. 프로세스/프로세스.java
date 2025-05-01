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
        //ArrayDeque<Integer> prior = new ArrayDeque<>(); -> 얘를 굳이 queue로 안해도 됨
        int maxP = priorities.length - 1;
        int turn = 1;
        while (true) {
            int curr = dq.pollFirst();
            if (map.get(curr) == priorities[maxP]) {
                //대기 중인 프로세스 중 우선순위 가장 높음
                
                if (curr == location) return turn;
                maxP--;
                turn++;
            }
            else {
                dq.add(curr);
            }
        }
    }
}