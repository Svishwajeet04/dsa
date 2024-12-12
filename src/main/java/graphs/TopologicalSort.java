package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, List.of(2));
        map.put(2, List.of(3));
        map.put(3, List.of(4,5));
        map.put(4, List.of(6));
        map.put(5, List.of());
        map.put(6, List.of());
        List<Integer> result = doTopologicalSort(map);
        System.out.println(result);
    }

    private static List<Integer> doTopologicalSort(Map<Integer, List<Integer>> map) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (var entry : map.entrySet()) {
            for (var val : entry.getValue()){
                countMap.compute(val, (k, o) -> o == null ? 1 : ++o);
            }
        }
        for (var key : map.keySet()){
            countMap.computeIfAbsent(key, keyz -> 0);
        }
        List<Integer> result = new ArrayList<>();
        while (!countMap.isEmpty()) {
            var map1 = new HashMap<>(countMap);
            int initial = map1.size();
            for (var entry : map1.entrySet()) {
                if (entry.getValue() == 0) {
                    var list = map.get(entry.getKey());
                    list.forEach(integer -> countMap.compute(integer, (integer1, integer2) -> --integer2));
                    countMap.remove(entry.getKey());
                    result.add(entry.getKey());
                }
            }
            if(initial == countMap.size()){
                throw new RuntimeException("cannot be sorted");
            }
        }
        return result;
    }
}
