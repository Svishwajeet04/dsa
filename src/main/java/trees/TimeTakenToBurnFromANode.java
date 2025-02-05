package trees;

import java.util.HashMap;
import java.util.Map;

public class TimeTakenToBurnFromANode {

    public static void main(String[] args) {
        Tree tree = new Tree(3)
                .setLeft(new Tree(5)
                        .setLeft(new Tree(6))
                        .setRight(new Tree(2)
                                .setRight(new Tree(4))
                                .setLeft(new Tree(7).setLeft(new Tree(11))))
                )
                .setRight(new Tree(1)
                        .setLeft(new Tree(0))
                        .setRight(new Tree(8)));

        int node = 8;

        Map<Tree, Tree> map = new HashMap<>();
        generateMap(map, tree);
        Tree searched = searchTree(node, tree);
        Map<Tree, Boolean> visited = new HashMap<>();
        System.out.println(getTimeTakenToBurnFromANode(visited, searched, map, 0));
    }

    private static int getTimeTakenToBurnFromANode(Map<Tree, Boolean> visited, Tree searched, Map<Tree, Tree> map, int time) {
        if (searched != null) {
            int val = time;
            visited.put(searched, true);
            if (map.get(searched) != null && !visited.getOrDefault(map.get(searched), false)) {
                val = Math.max(val, getTimeTakenToBurnFromANode(visited, map.get(searched), map, time + 1));
            }
            if (searched.right != null && !visited.getOrDefault(searched.right, false)) {
                val = Math.max(val, getTimeTakenToBurnFromANode(visited, searched.right, map, time + 1));
            }
            if (searched.left != null && !visited.getOrDefault(searched.left, false)) {
                val = Math.max(val, getTimeTakenToBurnFromANode(visited, searched.left, map, time + 1));
            }
            return val;
        }
        return time;
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
