package arrays;

import java.util.Arrays;

public class Sort_zero_one_two {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 0, 1, 1, 0, 2, 1};
        solution.solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public void solution(int[] arr) {
            int n = arr.length;
            int i = 0;
            int zero = 0;
            int two = n - 1;

            while (i <= two) {
                if (arr[i] == 0) {
                    int temp = arr[zero];
                    arr[zero] = 0;
                    arr[i] = temp;
                    zero++;
                    i++;
                } else if (arr[i] == 1) {
                    i++;
                } else {
                    int temp = arr[two];
                    arr[two] = 2;
                    arr[i] = temp;
                    two--;
                }
            }
        }
    }
}
