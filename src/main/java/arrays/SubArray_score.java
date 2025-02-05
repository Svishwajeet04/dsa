package arrays;

public class SubArray_score {

    public static void main(String[] args) {
        System.out.println(pairWithMaxSum(new int[]{4, 3, 1, 5, 6}));
    }

    public static int pairWithMaxSum(int[] arr)  {
        int max = Integer.MIN_VALUE;
        int cs;
        int css;
        for(int i = 0; i < arr.length - 1; i++){
            cs = Math.min(arr[i], arr[i + 1]);
            css = Math.max(arr[i], arr[i + 1]);
            max = Math.max(css + cs, max);
            for(int j = i + 2; j < arr.length; j++){
                if(arr[j] <= cs){
                    css = cs;
                    cs = arr[j];
                }else if(arr[j] < css){
                    css = arr[j];
                }
                max = Math.max(css + cs, max);
            }
        }
        return max;
    }
}
