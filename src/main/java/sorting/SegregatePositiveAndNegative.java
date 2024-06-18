package sorting;

import java.util.Arrays;

public class SegregatePositiveAndNegative {

    public static void main(String[] args) {
        int [] arr = {-4, 56, -6, -7, 34, 35, -9, 58};
        int i = 0, j = arr.length -1;
        while(i < j){
            if(arr[i] < 0){
                i++;
            }else{
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("point " + i);
    }
}
