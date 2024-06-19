package sorting;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 0, 0, 2, 0, 2, 1, 2};
        doSort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void doSort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid < high){
            if(arr[mid] == 1){
                mid++;
            }else if(arr[mid] < 1){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                mid++;
                low++;
            }else{
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }
}
