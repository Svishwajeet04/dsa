package leetCode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (final String s : strs) {
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                String key = Arrays.toString(arr);
                map.compute(key, (k, o) -> {
                    if (o == null) {
                        o = new ArrayList<>();
                    }
                    o.add(s);
                    return o;
                });
            }
            return map.values().stream().toList();
        }

    }
}
