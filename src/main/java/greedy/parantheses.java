package greedy;

public class parantheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean sol = solution.isValid(" *(()");
        System.out.println(sol);
    }

    static class Solution {
        public boolean isValid(String s) {
            int[] a = check(s);
            return (a[1] >= 0 && a[0] <= 0);
        }

        public int[] check(String s) {
            if (s.isEmpty()) {
                return new int[]{0, 0};
            } else {
                int[] sol = check(s.substring(1));
                if (sol[0] < 0 || sol[1] < 0) {
                    return new int[]{-1, -1};
                }
                if (s.charAt(0) == '(') {
                    sol[0] -= 1;
                    sol[1] -= 1;
                } else if (s.charAt(0) == ')') {
                    sol[0] += 1;
                    sol[1] += 1;
                } else {
                    sol[0] -= 1;
                    sol[1] += 1;
                }
                return sol;
            }
        }
    }
}
