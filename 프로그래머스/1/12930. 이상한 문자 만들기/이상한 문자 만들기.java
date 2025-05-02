import java.util.*;
//하나 이상의 공백!!!!!
class Solution {
    public String solution(String s) {
        String answer = "";
        //단어별로 짝홀수 판단
        StringBuilder sb = new StringBuilder();
        int idx = 0; //공백 기준 각 단어별 인덱스
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) ==  ' ') {
                sb.append(s.charAt(i));
                idx = 0;
            }
            else {
                if (idx % 2 == 0) {
                    //짝수 -> 대문자
                    sb.append(String.valueOf(s.charAt(i)).toUpperCase());
                    idx++;
                }
                else {
                    //소문자
                    sb.append(String.valueOf(s.charAt(i)).toLowerCase());
                    idx++;
                }
            }
        }
        return sb.toString();
    }
}