package dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String x = "abc";
        String y = "abc";
        System.out.println(findLongestCommonSubsequence(x, y, x.length(), y.length()));
    }

    private static int findLongestCommonSubsequence(String x, String y, int xl, int yl) {
        int[][] memo = new int[xl+1][yl+1];
        for (int i = 0; i <= xl; i++) {
            for (int j = 0; j <= yl; j++) {
                if(i == 0 || j == 0){
                    memo[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= xl; i++) {
            for (int j = 1; j <= yl; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    memo[i][j] = 1 + memo[i-1][j-1];
                }else{
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        return memo[xl][yl];
    }


}
