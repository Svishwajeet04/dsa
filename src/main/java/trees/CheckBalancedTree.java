package trees;

public class CheckBalancedTree {

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
                .setRight(new Tree(14));

        System.out.println(doCheckBalancedTree(tree) != -1);
    }

    private static int doCheckBalancedTree(Tree tree) {
        if (tree == null) {
            return 0;
        } else {
            int r = doCheckBalancedTree(tree.right);
            int l = doCheckBalancedTree(tree.left);
            if (r == -1 || l == -1) {
                return -1;
            }
            return Math.abs(r - l) <= 1 ? Math.max(r, l) + 1 : -1;
        }
    }
}
