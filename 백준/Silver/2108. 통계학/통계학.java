import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i],1);
            }
            sum += arr[i];
        }


        int keys = Collections.max(map.values());  //최빈값 키
        List<Integer> nums = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == keys) {
                nums.add(entry.getKey());
            }
        }
        Collections.sort(nums);
        int maxF = nums.size() >= 2 ? nums.get(1) : nums.get(0);

        int avg = (int) Math.round((double) sum / N);
        Arrays.sort(arr);
        int mid = arr[N/2];
        int range = arr[N-1] - arr[0];
        System.out.println(avg);
        System.out.println(mid);
        System.out.println(maxF);
        System.out.println(range);
    }
}
