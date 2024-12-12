package trie;

import java.util.List;

public class word_break {
    public static void main(String[] args) {
        Solution solution = new Solution();
        var res = solution.wordBreak("applepenapple", List.of("apple", "pen"));
        System.out.println(res);
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict.contains(s)) {
                return true;
            } else {
                return wordBreak(s, 0, 0, wordDict);
            }
        }

        public boolean wordBreak(String s, int start, int end, List<String> wordDict) {
            if (start >= s.length()) {
                return true;
            }
            boolean contains = wordDict.contains(s.substring(start, end));
            if (end == s.length()) {
                return contains;
            }
            return wordBreak(s, start, end + 1, wordDict) || contains && wordBreak(s, end, end + 1, wordDict);
        }
    }
}
