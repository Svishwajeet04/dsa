package arrays;

public class MaxLengthSubArrEvenOdd {

    public static void main(String[] args) {
        int[] arr = new int[]{34, 45, 67, 22, 44, 66, 88, 23, 56, 34, 79};
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        if(arr == null){
            throw new RuntimeException("arr is null");
        }else{
            int maxLen = 0;
            int currLen = 1;
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] % 2 == 0){
                    if(arr[i-1] % 2 != 0){
                        currLen++;
                    }else{
                        currLen = 1;
                    }
                }else{
                    if(arr[i-1] % 2 == 0){
                        currLen++;
                    }else{
                        currLen = 1;
                    }
                }
                if(currLen > maxLen){
                    maxLen = currLen;
                }
            }
            return maxLen;
        }
    }
}
