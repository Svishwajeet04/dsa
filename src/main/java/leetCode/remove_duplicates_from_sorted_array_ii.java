package leetCode;

public class remove_duplicates_from_sorted_array_ii {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3, 4, 4};
        int res = removeDuplicates(arr);
        for (int i = 0; i < res; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int ref = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[ref]) {
                nums[ref + 1] = nums[i];
                ref++;
            }
        }
        return ref + 1;
    }
}
