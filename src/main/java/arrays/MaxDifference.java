package arrays;

public class MaxDifference {

//  Given an array arr[] of integers, find out the maximum difference between any two elements such that the larger element appears after the smaller number.
    public static void main(String[] args) {
        int[] arr = new int[]{91, 3 , 45, 34, 24, 78, 88, 90, 47, 2};
        int maxd = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (min > j) {
                min = j;
            }
            int abs = Math.abs(j - min);
            if (maxd < abs) {
                maxd = abs;
            }
        }
        System.out.println(maxd);
    }
}
