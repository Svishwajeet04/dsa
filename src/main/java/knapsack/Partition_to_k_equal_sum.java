package knapsack;

import java.util.Arrays;

public class Partition_to_k_equal_sum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
    }

    static class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
//            Arrays.sort(nums);
            int sum = 0;
            for(int i : nums){
                sum += i;
            }
            if(sum % k != 0){
                return false;
            }else{
                int partSum = sum/k;
                boolean [] visited = new boolean[nums.length];
                boolean sumPossible;
                for(int i = 0; i < k ; i++){
                    sumPossible = findSum(partSum , nums, visited, nums.length);
                    if(!sumPossible){
                        return false;
                    }
                }
                return true;
            }
        }

        boolean findSum(int partSum ,int[] nums, boolean[] visited, int length){
            if(partSum == 0){
                return true;
            }else if(length == 0){
                return false;
            }else{
                if(!visited[length-1] && nums[length - 1] <= partSum){
                    boolean included = findSum(partSum - nums[length - 1] , nums, visited, length - 1);
                    if(included){
                        visited[length - 1] = true;
                        return true;
                    }
                }
                return findSum(partSum , nums, visited, length - 1);
            }
        }
    }
}
