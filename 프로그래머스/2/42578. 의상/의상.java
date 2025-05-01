import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (String[] c : clothes) {
            if (map.containsKey(c[1])) {
                map.get(c[1]).add(c[0]);
            }
            else {
                map.put(c[1],new ArrayList<>());
                map.get(c[1]).add(c[0]);
            }
        }
        
        for (ArrayList al : map.values()) {
            answer *= al.size() + 1;
        }
        return answer - 1;
    }
}