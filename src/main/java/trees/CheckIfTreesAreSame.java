package trees;

public class CheckIfTreesAreSame {
    public static void main(String[] args) {
        Tree tree1 = new Tree()
                .setVal(13)
                .setLeft(new Tree().setVal(1).setLeft(
                                new Tree().setVal(2)
                                        .setLeft(new Tree().setVal(4))
                                        .setRight(new Tree().setVal(5)
                                                .setLeft(new Tree(6))
                                                .setRight(new Tree(7))))
                        .setRight(new Tree(3)))
                .setRight(new Tree(14));
        Tree tree2 = new Tree()
                .setVal(13)
                .setLeft(new Tree().setVal(1).setLeft(
                                new Tree().setVal(2)
                                        .setLeft(new Tree().setVal(4))
                                        .setRight(new Tree().setVal(5)
                                                .setLeft(new Tree(6))
                                                .setRight(new Tree(7))))
                        .setRight(new Tree(3)))
                .setRight(new Tree(14));
        System.out.println(doCheckIfTreesAreSame(tree1, tree2));
    }

    private static boolean doCheckIfTreesAreSame(Tree tree1, Tree tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        } else if (tree1 == null || tree2 == null) {
            return false;
        } else if (tree1.val != tree2.val) {
            return false;
        } else {
            return doCheckIfTreesAreSame(tree1.right, tree2.right)
                    && doCheckIfTreesAreSame(tree1.left, tree2.left);
        }
    }
}
