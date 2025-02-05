package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeAtKthDist {

    public static void main(String[] args) {
        Tree tree = new Tree(3)
                .setLeft(new Tree(5)
                        .setLeft(new Tree(6))
                        .setRight(new Tree(2)
                                .setRight(new Tree(4))
                                .setLeft(new Tree(7)))
                )
                .setRight(new Tree(1)
                        .setLeft(new Tree(0))
                        .setRight(new Tree(8)));

        int node = 8;
        int distance = 2;

        Map<Tree, Tree> map = new HashMap<>();
        generateMap(map, tree);
        Tree searched = searchTree(node, tree);
        Map<Tree, Boolean> visited = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        getNodeAtKthDistance(visited, searched, map, res, distance);
        System.out.println(res);
    }

    private static void getNodeAtKthDistance(Map<Tree, Boolean> visited, Tree searched, Map<Tree, Tree> map, List<Integer> res, int distance) {
        if(distance != 0){
            visited.put(searched, true);
            if (map.get(searched) != null && !visited.getOrDefault(map.get(searched), false)) {
                getNodeAtKthDistance(visited, map.get(searched), map, res, distance - 1);
            }
            if (searched.right != null && !visited.getOrDefault(searched.right, false)) {
                getNodeAtKthDistance(visited, searched.right, map, res, distance - 1);
            }
            if (searched.left != null && !visited.getOrDefault(searched.left, false)) {
                getNodeAtKthDistance(visited, searched.left, map, res, distance - 1);
            }
        }else{
            res.add(searched.val);
        }
    }

    private static Tree searchTree(int i, Tree tree) {
        if (tree != null) {
            if (tree.val == i) {
                return tree;
            }
            var res = searchTree(i, tree.left);
            if (res == null) {
                res = searchTree(i, tree.right);
            }
            return res;
        } else {
            return null;
        }
    }

    private static void generateMap(Map<Tree, Tree> map, Tree tree) {
        if (tree.left != null) {
            map.put(tree.left, tree);
            generateMap(map, tree.left);
        }
        if (tree.right != null) {
            map.put(tree.right, tree);
            generateMap(map, tree.right);
        }
    }
}
