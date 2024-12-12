package arrays;

public class count_subarrays_with_mul_less_than_k {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numSubarrayProductLessThanK(
                new int[]{
                        1,2,3,4,5
                }, 1
        );
        System.out.println(res);
    }

    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int count = 0;
            int mul = nums[0];
            for(int i = 0, j = 0; i < nums.length && j < nums.length;){
                if(mul < k){
                    count = count + j - i + 1;
                    j++;
                    if(j < nums.length){
                        mul *= nums[j];
                    }
                }else{
                    i++;
                    mul /= nums[i-1];
                    if(i > j){
                        j = i;
                        if(i < nums.length){
                            mul = nums[i];
                        }
                    }
                }
            }
            return count;
        }
    }
}
