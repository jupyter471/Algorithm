class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for (int end = s.length(); end >= 0; end--) {  //문자열 길이
            for (int start = 0; start + end <= s.length(); start++) {
                if (ispal(start,end+start-1,s)) {
                    return end;
                }
            }
        }

        return answer;
    }
    
    public static boolean ispal(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}