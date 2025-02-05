package knapsack;

public class CountOfSubsetWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        final var sum = 8;
        int res = solveCountOfSubsetWithGivenSum(arr, arr.length, sum, 0);
        System.out.println(res);
    }

    private static int solveCountOfSubsetWithGivenSum(int[] arr, int length, int sum, int ans) {
        if (sum == 0) {
            return ++ans;
        } else if (length == 0) {
            return ans;
        } else {
            if (arr[length - 1] > sum) {
                return solveCountOfSubsetWithGivenSum(arr, length - 1, sum, ans);
            } else {
                return solveCountOfSubsetWithGivenSum(arr, length - 1, sum, ans)
                        + solveCountOfSubsetWithGivenSum(arr, length - 1, sum - arr[length - 1], ans);
            }
        }
    }
}
