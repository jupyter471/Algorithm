import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        //뽑은 인형 보관
        Deque<Integer> bbob = new ArrayDeque<>();
                
        for (int m : moves) {
            int c = m - 1;
            
            for (int i = 0; i < board.length; i++) {
                if (board[i][c] != 0) {
                    //뽑기
                    if (!bbob.isEmpty() && (bbob.peekLast() == board[i][c])) {
                        answer += 2;
                        bbob.pollLast();
                        board[i][c] = 0;
                        break;
                    }
                    else {
                        bbob.addLast(board[i][c]);
                        board[i][c] = 0;
                        break;
                    }
                    
                    //빼기
                }
            }
        }
        return answer;
    }
}