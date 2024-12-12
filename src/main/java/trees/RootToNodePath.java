package trees;

public class RootToNodePath {

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
        var path = rootToNodePath(root, 10, "");
        System.out.println(path);
    }

    private static String rootToNodePath(TreeNode root, int node, String path) {
        if (root == null) {
            return null;
        } else if (root.val == node) {
            return path + "->" + node;
        } else {
            path = path.isEmpty() ? path + root.val : path + "->" + root.val;
            var right = rootToNodePath(root.right, node, path);
            var left = rootToNodePath(root.left, node, path);
            if (right != null) {
                return right;
            }
            return left;
        }
    }
}
