class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(phone_number.length() - 4));
        sb.append(phone_number.substring(phone_number.length() - 4,phone_number.length()));
        //System.out.println(sb);
        return sb.toString();
    }
}