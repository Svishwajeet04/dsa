package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongSubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {3, 1, 0, 1, 4, 0, 1, 3, 2};
        int sum = 5;
        int max = getMax(arr, sum);
        System.out.println(max);
    }

    public static int getMax(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int last = 0;
        int max = Integer.MIN_VALUE;
        map.put(0, 0);
        for (int i = 0; i < arr.length; i++) {
            int key = last + arr[i] - sum;
            if (map.containsKey(key)) {
                int currentLength = i - map.get(key);
                if (currentLength > max) {
                    max = currentLength;
                }
            }
            if (!map.containsKey(last + arr[i])) {
                map.put(last + arr[i], i);
            }
            last += arr[i];
        }
        return max;
    }
}
