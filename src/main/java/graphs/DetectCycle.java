package graphs;

import java.util.*;

public class DetectCycle {

    public static void main(String[] args) {
        int n = 3;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, List.of(2, 3));
        map.put(2, List.of(1, 3));
        map.put(3, List.of(1, 2));
//        map.put(4, List.of(3, 8));
//        map.put(5, List.of(2));
//        map.put(6, List.of(2));
//        map.put(7, List.of(3, 8));
//        map.put(8, List.of(4, 7));
        boolean[] visited = new boolean[n + 1];
        boolean cycle = detectCycle(visited, map, map.keySet().stream().findFirst().get());
        System.out.println(cycle);
    }

    private static boolean detectCycle(boolean[] visited, Map<Integer, List<Integer>> map, int node) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(node, -1));
        visited[node] = true;
        while (!queue.isEmpty()) {
            int k = queue.size();
            for (int i = 0; i < k; i++) {
                Pair n1 = queue.remove();
                List<Integer> children = map.get(n1.val);
                for (Integer child : children) {
                    if (!visited[child]) {
                        visited[child] = true;
                        queue.add(new Pair(child, n1.val));
                    } else {
                        if (child != n1.parent) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static class Pair {
        int val;
        int parent;

        public Pair(int val, int parent) {
            this.val = val;
            this.parent = parent;
        }
    }
}
