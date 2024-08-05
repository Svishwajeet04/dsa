package recursions;

public class PrintNumberIfBinaryHasMore1than0 {

    public static void main(String[] args) {
//        Print N-bit binary numbers having more 1’s than 0’s for any prefix
        System.out.println(solvePrintNumberIfBinaryHasMore1than0(35));
    }

    private static boolean solvePrintNumberIfBinaryHasMore1than0(int i) {
        if (i > 0) {
            var val = checkIfBinaryHasMore1Than0(i);
            return val >= 0 && solvePrintNumberIfBinaryHasMore1than0(i / 2);
        } else {
            return true;
        }
    }

    private static int checkIfBinaryHasMore1Than0(int i) {
        if (!(i < 2)) {
            int rem = i % 2;
            int val = checkIfBinaryHasMore1Than0(i / 2);
            return val + (rem == 1 ? 1 : -1);
        } else {
            return i == 1 ? 1 : -1;
        }
    }
}
