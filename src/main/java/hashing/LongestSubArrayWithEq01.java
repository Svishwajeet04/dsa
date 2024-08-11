package hashing;

public class LongestSubArrayWithEq01 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int max = LongSubArrayWithGivenSum.getMax(arr, 0);
        System.out.println(max);
    }
}
