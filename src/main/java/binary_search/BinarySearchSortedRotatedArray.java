package binary_search;

public class BinarySearchSortedRotatedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{12, 45, 67, 78, 90, 344, 1, 2, 6};
        int[] arr1 = new int[]{90, 344, 1, 2, 6, 12, 45, 67, 78};
        System.out.println(binarySearchSortedRotatedArray(arr, 45) + 1);
        System.out.println(binarySearchSortedRotatedArray(arr1, 12) + 1);
    }

    private static int binarySearchSortedRotatedArray(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[l] < arr[mid]) {
//                left side sorted
                if (x >= arr[l] && x < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
//                right side sorted
                if (x > arr[mid] && x < arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -2;
    }
}
