package trees;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1)
                .setLeft(new TreeNode(2)
                        .setLeft(new TreeNode(4).setLeft(new TreeNode(7)).setRight(new TreeNode(8)))
                        .setRight(new TreeNode(5).setLeft(new TreeNode(9)).setRight(new TreeNode(10))))
                .setRight(new TreeNode(3)
                        .setRight(new TreeNode(6).setLeft(new TreeNode(11))
                                .setRight(new TreeNode(12))));

        System.out.println(getVerticalOrderTraversal(tree));
    }

    private static List<Integer> getVerticalOrderTraversal(TreeNode tree) {
        Map<Integer, List<Point>> verticals = new HashMap<>();
        fillVerticals(verticals, tree, 0, 0);
        return verticals.entrySet()
                .stream()
                .filter(integerListEntry -> integerListEntry.getKey() <= 0)
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(entry -> {
                    var ls = entry.getValue().stream().sorted(Comparator.comparingInt(value -> value.level)).toList();
                    return ls.get(0);
                })
                .map(point -> point.val.val)
                .toList();
    }

    static class Point {
        TreeNode val;
        int level;

        public Point(TreeNode val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    private static void fillVerticals(Map<Integer, List<Point>> verticals, TreeNode tree, int curr, int level) {
        if (tree != null) {
            verticals.compute(curr, (integer, integers) -> {
                if (integers == null) {
                    return new ArrayList<>(List.of(new Point(tree, level)));
                } else {
                    integers.add(new Point(tree, level));
                    return integers;
                }
            });
            fillVerticals(verticals, tree.left, curr - 1, level + 1);
            fillVerticals(verticals, tree.right, curr + 1, level + 1);
        }
    }
}
