package misc;

public class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        } else if (start + arr[start] > arr.length && start - arr[start] < 0) {
            return false;
        } else {
            return canReach(arr, start - arr[start])
                    || canReach(arr, start + arr[start]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }
}
