package arrays;

import java.util.Arrays;

public class MoveZeroesToEnd {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 66, 45, 0, 0, 0, 34, 24, 78, 88, 90, 47, 0};
        zeroesToEnd(arr);
    }

    private static void zeroesToEnd(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j){
            if(arr[i] == 0){
                swapVal(arr, i , j);
                j--;
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swapVal(int[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
