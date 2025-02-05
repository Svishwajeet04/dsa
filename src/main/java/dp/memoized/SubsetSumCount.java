package dp.memoized;

public class SubsetSumCount {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 8, 10};
        int sum = 10;
        int count = doSubsetSumCount(arr, sum);
        System.out.println(count);
    }

    private static int doSubsetSumCountRec(int[] arr, int sum, int length) {
        if (length == 0 && sum != 0) {
            return 0;
        } else if (sum == 0) {
            return 1;
        } else {
            if (arr[length - 1] <= sum) {
                return doSubsetSumCountRec(arr, sum - arr[length - 1], length - 1)
                        + doSubsetSumCountRec(arr, sum, length - 1);
            } else {
                return doSubsetSumCountRec(arr, sum, length - 1);
            }
        }
    }

    private static int doSubsetSumCount(int[] arr, int sum) {
        int[][] mem = new int[arr.length + 1][sum + 1];
        for (int i = 0; i < mem.length; i++) {
            mem[i][0] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= arr.length; j++)
                if (arr[j - 1] <= i) {
                    mem[i][j] = mem[i - 1][j - arr[i - 1]] + mem[i - 1][j];
                } else {
                    mem[i][j] = mem[i - 1][j];
                }
        }
        return mem[sum][arr.length];
    }
}
