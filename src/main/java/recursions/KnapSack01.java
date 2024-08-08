package recursions;

public class KnapSack01 {

    public static void main(String[] args) {
        int capacity = 7;
        int[] val = {1, 4, 5, 7};
        int[] weight = {1, 3, 4, 5};
        int res = doKnapSack01(val, weight, capacity, val.length);
        System.out.println(res);
    }

    private static int doKnapSack01(int[] val, int[] weight, int capacity, int length) {
        if (capacity == 0 || length == 0) {
            return 0;
        } else {
            int val1;
            if (weight[length - 1] > capacity) {
                val1 = doKnapSack01(val, weight, capacity, length - 1);
            } else {
                val1 = val[length - 1] + doKnapSack01(val, weight, capacity - weight[length - 1], length - 1);
                val1 = Math.max(val1, doKnapSack01(val, weight, capacity, length - 1));
            }
            return val1;
        }
    }

}
