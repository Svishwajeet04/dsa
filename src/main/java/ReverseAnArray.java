import java.util.Arrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 66, 45, 34, 24, 78, 88, 90, 47};
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, (arr.length - 1 - i));
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int i1) {
        var tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }
}
