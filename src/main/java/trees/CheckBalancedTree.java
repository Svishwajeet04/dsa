package trees;

public class CheckBalancedTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode()
                .setVal(13)
                .setLeft(new TreeNode().setVal(1).setLeft(
                                new TreeNode().setVal(2)
                                        .setLeft(new TreeNode().setVal(4))
                                        .setRight(new TreeNode().setVal(5)
                                                .setLeft(new TreeNode(6))
                                                .setRight(new TreeNode(7))))
                        .setRight(new TreeNode(3)))
                .setRight(new TreeNode(14));

        System.out.println(doCheckBalancedTree(treeNode) != -1);
    }

    private static int doCheckBalancedTree(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int r = doCheckBalancedTree(treeNode.right);
            int l = doCheckBalancedTree(treeNode.left);
            if (r == -1 || l == -1) {
                return -1;
            }
            return Math.abs(r - l) <= 1 ? Math.max(r, l) + 1 : -1;
        }
    }
}
