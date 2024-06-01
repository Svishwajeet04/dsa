package arrays;

public class MajorityElement {

//    moore's voting algorithm

    public static void main(String[] args) {
        int[] arr = new int[]{8, 6, 6, 8, 8, 8, 6, 4, 6, 8, 8};
        System.out.println(MajorityElement.solve(arr));
    }

    private static int solve(int[] arr) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[res]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count++;
            }
        }
        count = 0;
        for (int j : arr) {
            if (arr[res] == j) {
                count++;
            }
        }
        if (count > arr.length / 2) {
            return res;
        } else {
            return -1;
        }
    }
}
