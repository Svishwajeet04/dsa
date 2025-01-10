package misc;

public class Longest_palindromic_substring {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.longestPalindrome("babad");
        System.out.println(res);
    }

    static class Solution {
        public String longestPalindrome(String s) {
            String count = "";
            for (int i = 0; i < s.length(); i++) {
                int k = 0;
                String c = "";
                while (i + k < s.length() && i - k >= 0 && s.charAt(i - k) == s.charAt(i + k)) {
                    c = s.substring(i - k, i + k + 1);
                    k++;
                }
                if (c.length() > count.length()) {
                    count = c;
                }
            }
            for (int i = 0; i < s.length() - 1; i++) {
                int m = i;
                int n = i + 1;
                String c = "";
                while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
                    c = s.substring(m, n + 1);
                    m--;
                    n++;
                }
                if (count.length() < c.length()) {
                    count = c;
                }
            }
            return count;
        }
    }
}
