package graphs;

import java.util.*;

public class MinimumStepToMultiplicationTarget {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumMultiplications(new int[]{2,5,7}, 3, 30);
    }

    static class Solution {
        int minimumMultiplications(int[] arr, int start, int end) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(start);
            visited.add(start);
            int count = 0;
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    int node = queue.remove();
                    if (node == end) {
                        return count;
                    } else {
                        List<Integer> children = getChildren(node, arr, visited);
                        queue.addAll(children);
                    }
                }
                count++;
            }
            return -1;
        }

        List<Integer> getChildren(int node, int[] arr, Set<Integer> visited) {
            List<Integer> children = new ArrayList<>();
            for (int a : arr) {
                int val = ((node * a) % 100000);
                if (visited.add(val)) {
                    children.add(val);
                }
            }
            return children;
        }
    }

}
