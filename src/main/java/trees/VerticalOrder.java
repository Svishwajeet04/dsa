package trees;

import java.util.*;

public class VerticalOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1)
                .setRight(new TreeNode(7).setRight(new TreeNode(8)
                        .setLeft(new TreeNode(9)
                                .setLeft(new TreeNode(10))
                                .setRight(new TreeNode(11)))))
                .setLeft(new TreeNode(2)
                        .setLeft(new TreeNode(3)
                                .setRight(new TreeNode(4)
                                        .setLeft(new TreeNode(5))
                                        .setRight(new TreeNode(6)))));
        Map<Integer, List<Integer>> map = new HashMap<>();
        getVerticalOrder(map, root, 0);
        System.out.println(map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .flatMap(e -> e.getValue().stream())
                .toList());
    }

    private static void getVerticalOrder(Map<Integer, List<Integer>> map, TreeNode root, int x) {
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>(List.of(root.val)));
        }else {
            map.get(x).add(root.val);
        }
        if (root.left != null) {
            getVerticalOrder(map, root.left, x - 1);
        }
        if (root.right != null) {
            getVerticalOrder(map, root.right, x + 1);
        }
    }
}
