package graphs;

import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        int n = 9;
        int[] color = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, List.of(2));
        map.put(2, List.of(6, 3));
        map.put(3, List.of(9, 2));
        map.put(4, List.of(5, 7, 9));
        map.put(5, List.of(4, 6));
        map.put(6, List.of(5, 2));
        map.put(7, List.of(4, 8));
        map.put(8, List.of(7));
        map.put(9, List.of(3,4));
        boolean valid = checkBipartite(color, map);
        System.out.println(valid);
    }

    private static boolean checkBipartite(int[] color, Map<Integer, List<Integer>> map) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        color[1] = 1;
        int curr = 1;
        while (!queue.isEmpty()){
            int k = queue.size();
            curr = curr == 1 ? 2 : 1;
            for (int i = 0; i < k; i++) {
                int node = queue.remove();
                List<Integer> children = map.get(node);
                for (Integer child : children){
                    if (color[child] == 0) {
                        color[child] = curr;
                        queue.add(child);
                    } else {
                        if (color[child] != curr) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
