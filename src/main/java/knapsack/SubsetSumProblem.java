package knapsack;

public class SubsetSumProblem {

    public static Boolean[][] memo;

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10, 45, 56, 67, 78, 34, 45, 67, 34, 34, 12, 12,};
        int sum = 11;
        long start = System.currentTimeMillis();
        System.out.println(solveSubsetSumProblem(arr, arr.length, sum));
        System.out.println(System.currentTimeMillis() - start);
    }

    private static boolean solveSubsetSumProblem(int[] arr, int length, int sum) {
        if (memo == null) {
            memo = new Boolean[sum + 1][length + 1];
        }
        if(memo[sum][length] != null){
            return memo[sum][length];
        }
        if (sum == 0) {
            return memo[sum][length] = true;
        } else if (length == 0) {
            return memo[sum][length] = false;
        } else {
            if (arr[length - 1] > sum) {
                return memo[sum][length] = solveSubsetSumProblem(arr, length - 1, sum);
            } else {
                return memo[sum][length] = (solveSubsetSumProblem(arr, length - 1, sum - arr[length - 1])
                        || solveSubsetSumProblem(arr, length - 1, sum));
            }
        }
    }
}
