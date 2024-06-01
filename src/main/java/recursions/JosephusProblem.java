package recursions;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(solve(7, 3));
    }

    private static int solve(int i, int incr) {
        boolean[] killed = new boolean[i];
        int killedCount = 0;
        return doSolve(killed, i, killedCount, 0, incr);
    }

    private static int doSolve(boolean[] killed, int i, int killedCount, int index, int incr) {
        if (i == killedCount + 1) {
            for (int j = 0; j < killed.length; j++) {
                if (!killed[j]) {
                    return j;
                }
            }
        } else {
            int nextKilled = findNextIndex(killed, index, incr);
            killed[nextKilled] = true;
            System.out.printf("killed %d%n", nextKilled);
            killedCount++;
            index = findNextIndex(killed, nextKilled, 1);
            return doSolve(killed, i, killedCount, index, incr);
        }
        return -1;
    }

    private static int findNextIndex(boolean[] killed, int index, int incr) {
        int i = (index);
        int count = 0;
        while (count != incr) {
            i = i % killed.length;
            boolean isKilled = killed[i];
            if(!isKilled){
                count++;
            }
            i++;
        }
        return i - 1 % killed.length;
    }
}
