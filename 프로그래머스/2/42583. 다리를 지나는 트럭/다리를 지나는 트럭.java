import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        //투포인터?
        int head = 0;  //가장 선두에서 이동 중인 트럭 인덱스
        int tail = 0;  //새로 추가되는 트럭 인덱스
        
        int curr_weight = 0;
        int time = 0;
        
        //각 트럭의 입장 시간 
        Deque<Integer> enterTime = new ArrayDeque<>();
        
        while (tail < truck_weights.length && head <= tail) {
            time++;

            //다리를 지난 트럭 확인
            if (!enterTime.isEmpty() && enterTime.peekFirst() + bridge_length  <= time) {
                //System.out.println("start " + head + ", " + time);
                curr_weight -= truck_weights[head];
                head++;
                enterTime.pollFirst();
            }
            //System.out.println(curr_weight);
            
            //새로운 트럭 입장
            if ((curr_weight + truck_weights[tail]) <= weight && enterTime.size() < bridge_length) {
                //System.out.println(tail +  ", " + time);
                enterTime.add(time);
                curr_weight += truck_weights[tail];
                tail++;
            }
        }
        
        time += bridge_length;
        
        return time;
    }
}

//bridge_length 개, 총 무게 weight보다 작은을 때 동시 이동 가능
//건너는데 걸리는 총 시간 bridge_length
