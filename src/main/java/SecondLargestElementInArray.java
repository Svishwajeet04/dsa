public class SecondLargestElementInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 66, 45, 34, 24, 78, 88, 90, 47};
        printMax2(arr);
    }

    private static void printMax2(int[] arr) {
        if (arr.length < 2) {
            System.out.println("no second element");
        }
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max2 = max;
                max = j;
            } else {
                if (max2 < j) {
                    max2 = j;
                }
            }
        }
        System.out.println(max2);
    }
}
