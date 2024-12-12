package graphs;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            map.compute(u, (key, ls) -> {
                if(ls == null){
                    ls = new ArrayList<>();
                }
                ls.add(v);
                return ls;
            });
            map.compute(v, (key, ls) -> {
                if(ls == null){
                    ls = new ArrayList<>();
                }
                ls.add(u);
                return ls;
            });
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Integer firstEle = map.entrySet().stream().findFirst().get().getKey();
        queue.add(firstEle);
        List<Integer> result = new ArrayList<>();
        boolean [] visited = new boolean[n + 1];
        visited[firstEle] = true;
        while (!queue.isEmpty()){
            int k = queue.size();
            for (int i = 0; i < k; i++) {
                Integer val = queue.remove();
                List<Integer> children = map.get(val);
                result.add(val);
                for (Integer child : children) {
                    if (!visited[child]) {
                        queue.add(child);
                        visited[child] = true;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
