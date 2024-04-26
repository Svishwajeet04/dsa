public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 0, 2, 0, 4};
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        if (arr == null || arr.length <= 2) {
            return 0;
        } else {
            int[] lhmax = new int[arr.length];
            int[] rhmax = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    lhmax[i] = arr[i];
                } else {
                    lhmax[i] = Math.max(lhmax[i - 1], arr[i]);
                }
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (i == arr.length - 1) {
                    rhmax[i] = arr[i];
                } else {
                    rhmax[i] = Math.max(rhmax[i + 1], arr[i]);
                }
            }
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += (Math.min(lhmax[i], rhmax[i]) - arr[i]);
            }
            return count;
        }
    }
}
