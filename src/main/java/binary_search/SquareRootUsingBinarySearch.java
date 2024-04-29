package binary_search;

public class SquareRootUsingBinarySearch {

    public static void main(String[] args) {
        int sqrt = sqrtBS(81);
        System.out.println(sqrt);
    }

    private static int sqrtBS(int x) {
        int l = 0;
        int r = x;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            int sqr = mid * mid;
            if (sqr == x) {
                return mid;
            } else if (sqr > x) {
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return mid - 1;
    }
}
