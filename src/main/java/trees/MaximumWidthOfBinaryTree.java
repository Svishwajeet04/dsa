package trees;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        Tree tree = new Tree()
                .setVal(13)
                .setLeft(new Tree().setVal(1).setLeft(
                                new Tree().setVal(2)
                                        .setLeft(new Tree().setVal(4))
                                        .setRight(new Tree().setVal(5)
                                                .setLeft(new Tree(6))
                                                .setRight(new Tree(7))))
                        .setRight(new Tree(3)))
                .setRight(new Tree(14).setRight(new Tree(15).setRight(new Tree(16).setRight(new Tree(17)))));

        System.out.println(getMaximumWidthOfBinaryTree(tree));
    }

    private static int getMaximumWidthOfBinaryTree(Tree tree) {
        if (tree == null) {
            return 0;
        } else {
            int max = Integer.MIN_VALUE;
            List<IndexTree> list = new ArrayList<>();
            list.add(new IndexTree(1, tree));
            while (!list.isEmpty()) {
                int currentWidth = list.get(list.size() - 1).index - list.get(0).index + 1;
                if (max < currentWidth) {
                    max = currentWidth;
                }
                int n = list.size();
                int zero = list.get(0).index;
                for (int i = 0; i < n; i++) {
                    IndexTree node = list.remove(0);
                    if (node.tree.left != null) {
                        list.add(new IndexTree((2 * (node.index - zero)  + 1), node.tree.left));
                    }
                    if (node.tree.right != null) {
                        list.add(new IndexTree((2 * (node.index - zero)  + 2), node.tree.right));
                    }
                }
            }
            return max;
        }
    }

    static class IndexTree {
        int index;
        Tree tree;

        public IndexTree(int index, Tree tree) {
            this.index = index;
            this.tree = tree;
        }
    }

}
