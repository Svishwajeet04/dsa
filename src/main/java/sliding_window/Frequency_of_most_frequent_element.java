package sliding_window;

import java.util.Arrays;

public class Frequency_of_most_frequent_element {

    public static void main(String[] args) {
        int[] arr = new int[30000];
        for (int i = 0; i < 30000 - 1; i++) {
            arr[i] = 1;
        }
        arr[30000 - 1] = 100000;
        Solution solution = new Solution();
        int res = solution.maxFrequency(arr, 1);
        System.out.println(res);
    }

    static class Solution {
        public int maxFrequency(int[] nums, int k) {
            int l = 0;
            int r = 0;
            Arrays.sort(nums);
            System.out.println(nums.length);
            int ans = 0;
            double sum = nums[0];
            while (l < nums.length && r < nums.length) {
                double required = (nums[r] * (double)(r - l + 1)) % Integer.MAX_VALUE;
                System.out.println(required + " "  + sum);
                if ((sum + k) >= required) {
                    if (ans < (r - l + 1)) {
                        ans = (r - l + 1);
                    }
                    r++;
                    if (r < nums.length) {
                        sum += nums[r];
                    }
                } else {
                    sum -= nums[l];
                    l++;
                }
                sum %= Integer.MAX_VALUE;
            }
            return ans;
        }
    }
}
