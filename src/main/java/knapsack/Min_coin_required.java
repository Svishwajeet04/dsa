package knapsack;

public class Min_coin_required {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{2, 5, 10, 1}, 27));
    }

    static class Solution {
        int[][] memo;
        int count = 0;

        public int coinChange(int[] coins, int amount) {
            memo = new int[coins.length + 1][amount + 1];
            for (int i = 0; i < memo.length; i++) {
                for (int j = 0; j < memo[0].length; j++) {
                    memo[i][j] = Integer.MIN_VALUE;
                }
            }
            return coinChange(coins, coins.length, amount);
        }

        public int coinChange(int[] coins, int n, int amount) {
            if (amount == 0) {
                return 0;
            } else if (n == 0) {
                return -1;
            } else {
                if(memo[n][amount] != Integer.MIN_VALUE){
                    System.out.println(++count);
                    return memo[n][amount];
                }
                if (coins[n - 1] <= amount) {
                    int included = coinChange(coins, n, amount - coins[n - 1]);
                    int notIncluded = coinChange(coins, n - 1, amount);
                    int val;
                    if (included == -1 && notIncluded == -1) {
                        val = -1;
                    } else {
                        if (included != -1 && notIncluded == -1) {
                            val = included + 1;
                        } else if (included == -1 && notIncluded != -1) {
                            val = notIncluded;
                        } else {
                            val = Math.min(included + 1, notIncluded);
                        }
                    }
                    return memo[n][amount] = val;
                } else {
                    return coinChange(coins, n - 1, amount);
                }
            }
        }
    }
}
