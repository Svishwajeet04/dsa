package arrays;

public class MaxConsecutive1s {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1};
        System.out.println(MaxConsecutive1s.solve(arr));
    }

    private static int solve(int[] arr) {
        int currCount = 0;
        int maxCount = 0;
        for (int j : arr) {
            if (j == 0) {
                currCount = 0;
            } else {
                currCount++;
                if (currCount > maxCount) {
                    maxCount = currCount;
                }
            }
        }
        return maxCount;
    }
}
