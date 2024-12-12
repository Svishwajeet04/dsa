package dp.memoized;

import java.util.Arrays;

public class TargetSum {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int val = doTargetSum(arr, 1);
        System.out.println(val);
    }

    private static int doTargetSum(int[] arr, int target) {
        int sum = Arrays.stream(arr).sum();
        int[][] mem = new int[arr.length + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            mem[0][i] = 0;
        }
        for (int j = 0; j <= arr.length; j++) {
            mem[j][0] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= arr.length; j++) {
                if (arr[j - 1] > i) {
                    mem[i][j] = mem[j - 1][i];
                } else {
                    mem[j][i] = mem[j - 1][i] + mem[j - 1][i - arr[j - 1]];
                }
            }
        }
        return mem[arr.length][(target + sum) / 2];
    }
}
