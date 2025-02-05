package dp;

public class SubsetSumCount {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 8, 12, 13, 5};
        int sum = 10;
        int res = doSubsetSumCount(arr, sum, 0);
        System.out.println(res);
    }

    private static int doSubsetSumCount(int[] arr, int sum, int i) {
        if(i == arr.length && sum != 0){
            return 0;
        }else if(sum == 0){
            return 1;
        }else{
            if(arr[i] <= sum ){
                var incl = doSubsetSumCount(arr, sum - arr[i] , i+1);
                var excl = doSubsetSumCount(arr, sum, i+1);
                return incl + excl;
            }else{
                return doSubsetSumCount(arr, sum, i + 1);
            }
        }
    }
}
