package two_pointer;

import java.util.Arrays;

// find pair sum in sorted array
public class PairSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 8, 12, 30};
        System.out.println(Arrays.toString(findPairSumInSortedArray(arr, 20)));
        System.out.println(Arrays.toString(findPairSumInSortedArray(arr, 17)));
    }

    private static int[] findPairSumInSortedArray(int[] arr, int val) {
        int i = 0;
        int j = arr.length - 1;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == val){
                res[0] = i;
                res[1] = j;
                return res;
            }else if(sum > val){
                j--;
            }else{
                i++;
            }
        }
        return res;
    }
}
