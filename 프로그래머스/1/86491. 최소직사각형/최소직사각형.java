class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0; //큰 거
        int h = 0;  // 작은 거
        for (int i = 0; i < sizes.length; i++) {
            w = Math.max(w, Math.max(sizes[i][0], sizes[i][1]));
            h = Math.max(h, Math.min(sizes[i][0], sizes[i][1]));
        }
        //
        return w * h;
    }
}