package trees;

public class CheckIfTreesAreSame {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode()
                .setVal(13)
                .setLeft(new TreeNode().setVal(1).setLeft(
                                new TreeNode().setVal(2)
                                        .setLeft(new TreeNode().setVal(4))
                                        .setRight(new TreeNode().setVal(5)
                                                .setLeft(new TreeNode(6))
                                                .setRight(new TreeNode(7))))
                        .setRight(new TreeNode(3)))
                .setRight(new TreeNode(14));
        TreeNode treeNode2 = new TreeNode()
                .setVal(13)
                .setLeft(new TreeNode().setVal(1).setLeft(
                                new TreeNode().setVal(2)
                                        .setLeft(new TreeNode().setVal(4))
                                        .setRight(new TreeNode().setVal(5)
                                                .setLeft(new TreeNode(6))
                                                .setRight(new TreeNode(7))))
                        .setRight(new TreeNode(3)))
                .setRight(new TreeNode(14));
        System.out.println(doCheckIfTreesAreSame(treeNode1, treeNode2));
    }

    private static boolean doCheckIfTreesAreSame(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        } else if (treeNode1 == null || treeNode2 == null) {
            return false;
        } else if (treeNode1.val != treeNode2.val) {
            return false;
        } else {
            return doCheckIfTreesAreSame(treeNode1.right, treeNode2.right)
                    && doCheckIfTreesAreSame(treeNode1.left, treeNode2.left);
        }
    }
}
