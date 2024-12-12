package arrays;

public class Count_subrrays_with_sum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subarraySum(new int[]{
                1,2,3
        }, 3);
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] presum = new int[nums.length];
            presum[0] = nums[0];
            for(int i = 1 ; i <  nums.length; i++){
                presum[i] = nums[i] + presum[i-1];
            }
            int count = 0;
            for(int i = 0; i < nums.length ; i++){
                for(int j = i ; j < nums.length; j++){
                    int leftSum = i == 0 ? presum[i-1] : 0;
                    int rightSum = presum[j];
                    if(rightSum - leftSum == k){
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
