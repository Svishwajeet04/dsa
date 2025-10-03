package stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class next_greater_circular {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 1};
        int[] res = solution.nextGreaterElements(a);
        System.out.println(Arrays.toString(res));
        a = new int[]{2, 1, 2};
        res = solution.nextGreaterElements(a);
        System.out.println(Arrays.toString(res));
    }

    static class Solution {
        public int[] nextGreaterElements(int[] a) {
            Stack<Integer> st = new Stack<>();
            int max = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > a[max]) {
                    max = i;
                }
            }
            int[] res = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                res[i] = -2;
            }
            int k = max;
            do {
                if (st.isEmpty()) {
                    res[k] = -1;
                    st.add(res[k]);
                } else {
                    while (st.peek() <= a[k]) {
                        st.pop();
                        if (st.isEmpty()) {
                            break;
                        }
                    }
                    res[k] = st.isEmpty() ? -1 : st.peek();
                    st.add(res[k]);
                }
                k--;
                if (k < 0) {
                    k = a.length - 1;
                }
            } while (res[k] == -2);
            return res;
        }
    }

}
