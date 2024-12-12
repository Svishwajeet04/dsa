package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {

    public static void main(String[] args) {
        int n = 8;
        int m = 8;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, List.of(2,3));
        map.put(2, List.of(1,5,6));
        map.put(3, List.of(1,4,7));
        map.put(4, List.of(3,8));
        map.put(5, List.of(2));
        map.put(6, List.of(2));
        map.put(7, List.of(3,8));
        map.put(8, List.of(4,7));
        boolean [] visited = new boolean[n + 1];
        List<Integer> result = new ArrayList<>();
        dfs(result, visited, map, map.keySet().stream().findFirst().get());
        System.out.println(result);
    }

    private static void dfs(List<Integer> result, boolean[] visited, Map<Integer, List<Integer>> map, int ele) {
        visited[ele] = true;
        result.add(ele);
        List<Integer> children = map.get(ele);
        for (Integer child : children) {
            if (!visited[child]) {
                dfs(result, visited, map, child);
            }
        }
    }
}
