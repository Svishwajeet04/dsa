package binary_search;

import java.util.Arrays;
// first occurrence in sorted array
public class BinarySearchRecursive {

    public static void main(String[] args) {
        int[] arr = new int[]{45, 23, 67, 34, 23, 90, 66, 23, 12};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index = binarySearchRecursion(arr, 0, arr.length - 1, 23);
        System.out.println(index);
    }

    private static int binarySearchRecursion(int[] arr, int l, int r, int num) {
        if (l > r) {
            return -1;
        } else {
            int mid = (l + r) / 2;
            if (arr[mid] == num) {
                if (mid != arr.length - 1 && arr[mid + 1] != num) {
                    return mid;
                } else {
                    return binarySearchRecursion(arr, mid + 1, r, num);
                }
            } else if (arr[mid] > num) {
                return binarySearchRecursion(arr, l, mid - 1, num);
            } else {
                return binarySearchRecursion(arr, mid + 1, r, num);
            }
        }
    }
}
