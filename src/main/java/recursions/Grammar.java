package recursions;

public class Grammar {

    public static void main(String[] args) {
        int n = 4;
        int k = 6;
        int res = solveGrammar(n, k);
        System.out.println(res);
    }

    private static int solveGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        } else {
            int res = solveGrammar(n - 1, (k + 1) / 2);
            if (k % 2 == 0) {
                if (res == 1) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (res == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

//    1 --> 10
//    0 --> 01
//    0
//            01
//            0110
//            01101001
}
