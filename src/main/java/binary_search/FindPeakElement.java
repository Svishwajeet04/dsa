package binary_search;

public class FindPeakElement {

    public static void main(String[] args) {
        int[] arr = new int[]{120, 80, 40, 30, 20, 50, 60};
        System.out.println(findPeakElement(arr));
    }

    private static int findPeakElement(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((mid + 1 == arr.length || arr[mid + 1] < arr[mid])
                    && (mid - 1 == -1 || arr[mid - 1] < arr[mid])) {
                return mid;
            } else if(arr[mid - 1] >= arr[mid]){
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
