package sorting;

import java.util.Arrays;

import static sorting.QsPartition.partition;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 12, 9, 55, 10, 7, 7};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        doQuickSort(arr, 0, arr.length - 1);
    }

    private static void doQuickSort(int[] arr, int l, int r) {
        if(l < r){
            int pivotIndex = partition(arr, l, r);
            doQuickSort(arr, l, pivotIndex - 1);
            doQuickSort(arr, pivotIndex + 1, r);
        }
    }
}
