package dp;

public class SubsetSumPossible {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 8, 12, 13, 5};
        int sum = 3;
        boolean res = isSubsetSumPossible(arr, sum, 0);
        System.out.println(res);
    }

    private static boolean isSubsetSumPossible(int[] arr, int sum, int i) {
        if(i == arr.length && sum != 0){
            return false;
        }else if(sum == 0){
            return true;
        }else{
            if(arr[i] <= sum ){
                return isSubsetSumPossible(arr, sum - arr[i] , i+1)
                        || isSubsetSumPossible(arr, sum, i+1);
            }else{
                return isSubsetSumPossible(arr, sum, i + 1);
            }
        }
    }
}
