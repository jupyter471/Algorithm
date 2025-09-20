import java.util.*;

// 10 파싱 조심

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] input = dartResult.toCharArray();
        int idx = 0;
        int N = input.length;
        int[] scores = new int[3]; //게임은 3라운드 각 라운드의 점수를 저장
        
        int scoreIdx = 0;
        while (idx < N) {
            //1. 숫자
            int num;
            char c = input[idx];
            if (c == '1' && input[idx+1] == '0') {
                num = 10;
                idx += 2;
            }
            else {
                num = c - '0';
                idx++;
            }
            
            //2. 보너스
            int cur = num;
            char bonus = input[idx++];
            if (bonus == 'D') {
                cur = (int) Math.pow(num,2);
            }
            else if (bonus == 'T') {
                cur = (int) Math.pow(num,3);
            }
            
            scores[scoreIdx] = cur;
            
            //3. 옵션
            if (idx < N) {
                if (input[idx] == '*' || input[idx] == '#') {
                    int last = scores[scoreIdx];
                    if (input[idx] == '#') {
                        last *= -1;
                        scores[scoreIdx] = last;
                    }
                    else {
                        last *= 2;
                        scores[scoreIdx] = last;
                        if (scoreIdx > 0) {
                            scores[scoreIdx-1] *= 2;
                        }
                    }
                    idx++;
                }
            }
            
            scoreIdx++;
        }
        
        for (int score : scores) {
                answer += score;
            }
        return answer;
    }
}