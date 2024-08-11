package recursions;

import java.util.Arrays;

public class InsertAtPlace {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 5, 6, 7, 0};
        solve(arr, arr[arr.length - 1], 0, arr.length - 2);
        System.out.println(Arrays.toString(arr));
    }

    private static void solve(int[] arr, int i, int l, int r) {
        if (r < l || arr[r] <= i) {
            arr[r + 1] = i;
        } else {
            int val = arr[r];
            solve(arr, i, l, r - 1);
            arr[r + 1] = val;
        }
    }
}
