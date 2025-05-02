import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] com : commands) {
            int size = com[1] - com[0] + 1;
            int[] trim = new int[size];
            for (int i = 0; i < size; i++) {
                trim[i] = array[i+com[0]-1];
            }
            Arrays.sort(trim);
            answer[idx++] = trim[com[2]-1];
        }
        return answer;
    }
}