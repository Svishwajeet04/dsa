package sorting;

import java.util.Arrays;

public class ChoclateDistributionProblem {

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 45};
        int k = 3;
        int diff = minimumDiff(arr, k);
        System.out.println(diff);
    }

    private static int minimumDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length - k; i++){
            if(min > (arr[i + k -1] - arr[i])){
                min = (arr[i + k -1] - arr[i]);
            }
        }
        return min;
    }
}
