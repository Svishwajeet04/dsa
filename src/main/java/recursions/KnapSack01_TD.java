package recursions;

public class KnapSack01_TD {

    public static void main(String[] args) {
        int capacity = 7;
        int[] val = {1, 4, 5, 7};
        int[] weight = {1, 3, 4, 5};
        int res = doKnapSack01_TD(val, weight, capacity, val.length);
        System.out.println(res);
    }

    private static int doKnapSack01_TD(int[] val, int[] weight, int capacity, int length) {
        var memo = new int[length + 1][capacity + 1];
        for (int i = 1; i <= capacity; i++) {
            for (int j = 1; j <= length; j++) {
                int val1;
                if (weight[j - 1] > i) {
                    val1 = memo[j - 1][i];
                } else {
                    val1 = val[j - 1] + memo[j - 1][i - weight[j - 1]];
                    val1 = Math.max(val1, memo[j - 1][i]);
                }
                memo[j][i] = val1;
            }
        }
        return memo[length][capacity];
    }
}
