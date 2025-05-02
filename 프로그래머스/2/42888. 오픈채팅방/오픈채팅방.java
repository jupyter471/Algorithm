import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("Enter","님이 들어왔습니다.");
        map.put("Leave", "님이 나갔습니다.");
                
        HashMap<String, String> id = new HashMap<>();
        for (String s : record) {
            String[] arr = s.split(" ");
            if (arr[0].equals("Enter") || arr[0].equals("Change")) {
                //새로운 멤버
                id.put(arr[1],arr[2]);
            }
        }
        
        for (String s : record) {
            String[] arr = s.split(" ");
            
            if (arr[0].equals("Change")) continue;
            answer.add(id.get(arr[1]) + map.get(arr[0]));
        }
        
        //System.out.println(answer);
        
        return answer.toArray(new String[0]);
    }
}