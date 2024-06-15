package sorting;

import java.util.Arrays;

public class QsPartition {

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 12, 9, 55, 10, 7, 7};
        System.out.println(partition(arr,0, arr.length -1));
        System.out.println(Arrays.toString(arr));
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l, j = r - 1;
        while (i < j) {
            if (arr[i] <= pivot) {
                i++;
            } else {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j--;
            }
        }
        arr[r] = arr[i];
        arr[i] = pivot;
        return i;
    }
}
