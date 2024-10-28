package trees;

import java.util.Optional;

public class ChildrenSumProperty {
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

        getChildrenSumProperty(tree);
        tree.printTreeStructure();
    }

    private static Integer getChildrenSumProperty(Tree tree) {
        if (tree == null) {
            return null;
        } else {
            Integer left = getChildrenSumProperty(tree.left);
            Integer right = getChildrenSumProperty(tree.right);
            if (!(right == null && left == null)) {
                tree.val = Optional.ofNullable(left).orElse(0) + Optional.ofNullable(right).orElse(0);
            }
            return tree.val;
        }
    }
}
