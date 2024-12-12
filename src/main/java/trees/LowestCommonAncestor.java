package trees;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1)
                .setRight(new TreeNode(7)
                        .setLeft(new TreeNode(55))
                        .setRight(new TreeNode(8)
                        .setLeft(new TreeNode(9)
                                .setLeft(new TreeNode(10))
                                .setRight(new TreeNode(11)))))
                .setLeft(new TreeNode(2)
                        .setLeft(new TreeNode(3)
                                .setRight(new TreeNode(4)
                                        .setLeft(new TreeNode(5))
                                        .setRight(new TreeNode(6)))));
        var path = getLowestCommonAncestor(root, 56, 10);
        System.out.println(path);
    }

    private static Integer getLowestCommonAncestor(TreeNode root, int node1, int node2) {
        if (root == null) {
            return null;
        } else if (root.val == node1 || root.val == node2) {
            return root.val;
        } else {
            var left = getLowestCommonAncestor(root.left, node1, node2);
            var right = getLowestCommonAncestor(root.right, node1, node2);
            if(left != null && right != null){
                return root.val;
            }else{
                return left != null ? left : right;
            }
        }
    }
}
