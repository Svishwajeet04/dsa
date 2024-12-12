package graphs;

import java.util.*;

public class WordLadder {

//    https://www.geeksforgeeks.org/problems/word-ladder/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=word-ladder

    /**
     * Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
     * Keep the following conditions in mind:
     * <p>
     * A word can only consist of lowercase characters.
     * Only one letter can be changed in each transformation.
     * Each transformed word must exist in the wordList including the targetWord.
     * startWord may or may not be part of the wordList
     * The second part of this problem can be found here.
     * <p>
     * Note: If no possible way to transform sequence from startWord to targetWord return 0
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input:
     * wordList = {"des","der","dfr","dgt","dfs"}
     * startWord = "der", targetWord= "dfs",
     * Output:
     * 3
     * Explanation:
     * The length of the smallest transformation
     * sequence from "der" to "dfs" is 3
     * i,e "der" -> "dfr" -> "dfs".
     * Example 2:
     * <p>
     * Input:
     * wordList = {"geek", "gefk"}
     * startWord = "gedk", targetWord= "geek",
     * Output:
     * 2
     * Explanation:
     * gedk -> geek
     * Example 3:
     * <p>
     * Input:
     * wordList = {"poon", "plee", "same", "poie","plea","plie","poin"}
     * startWord = "toon", targetWord= "plea",
     * Output: 7
     * Explanation:
     * toon -> poon -> poin -> poie -> plie -> plee -> plea
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] str = {"des", "der", "dfr", "dgt", "dfs"};
        String startWord = "der";
        String targetWord = "dfs";
        int res = wordOrder(str, startWord, targetWord);
        System.out.println(res);
    }

    private static int wordOrder(String[] str, String startWord, String targetWord) {
        int res = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(startWord);
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(startWord, true);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                res++;
                String word = queue.remove();
                List<String> children = getChildren(word, targetWord, str, visited);
                if (children != null) {
                    queue.addAll(children);
                } else {
                    return -1;
                }
            }
        }
        return res - 1;
    }

    private static List<String> getChildren(String word, String targetWord, String[] str, Map<String, Boolean> visited) {
        List<String> children = new ArrayList<>();
        for (String next : str) {
            if (!visited.getOrDefault(next, false) && onlyOneDiff(word, next) == 1) {
                if (next.equals(targetWord)) {
                    return List.of();
                }
                children.add(next);
            }
        }
        return children.isEmpty() ? null : children;
    }

    private static int onlyOneDiff(String word, String next) {
        if (word.equals(next)) {
            return 0;
        } else {
            return (word.charAt(0) == next.charAt(0) ? 0 : 1) + onlyOneDiff(word.substring(1), next.substring(1));
        }
    }
}
