package arrays;

import java.util.ArrayList;
import java.util.List;

public class CircularSubarrays {

    public static List<List<Integer>> circularSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        // Iterate through all possible starting indices
        for (int i = 0; i < n; i++) {
            // Iterate through all possible ending indices
            for (int j = i; j < n + i; j++) {
                // Get the circular subarray
                List<Integer> subarray = getSubarray(arr, i, j % n);
                result.add(subarray);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<List<Integer>> result = circularSubarrays(arr);
        System.out.println(result);
    }

    // Helper function to get subarrays
    private static List<Integer> getSubarray(int[] arr, int start, int end) {
        List<Integer> subarray = new ArrayList<>();
        if (end >= start) {
            for (int i = start; i <= end; i++) {
                subarray.add(arr[i]);
            }
        } else {
            for (int i = start; i < arr.length; i++) {
                subarray.add(arr[i]);
            }
            for (int i = 0; i <= end; i++) {
                subarray.add(arr[i]);
            }
        }
        return subarray;
    }
}
