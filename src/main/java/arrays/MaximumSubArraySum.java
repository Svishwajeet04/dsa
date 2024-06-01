package arrays;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 45, 45, 23, 344, -23, -22, 45};
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("arr is null");
        } else {
            int[] maxes = new int[arr.length];
            maxes[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                maxes[i] = Math.max(arr[i], maxes[i - 1] + arr[i]);
            }
            int max = Integer.MIN_VALUE;
            for (int j : maxes) {
                if (j > max) {
                    max = j;
                }
            }
            return max;
        }
    }
}
