package sorting;

import java.util.Arrays;

public class QsPartition {

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 12, 9 , 55, 10, 7, 7};
        int index = 6;
        System.out.println(Arrays.toString(partition(arr, index)));
    }

    private static int[] partition(int[] arr, int index) {
        int pivot = arr[index];
        for (int i = 0, j = arr.length - 1; i < j; ) {
            if(arr[i] <= pivot){
                i++;
            }else{
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j--;
            }
        }
        return arr;
    }
}
