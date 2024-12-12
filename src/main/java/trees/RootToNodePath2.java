package trees;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath2 {
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
        var path = rootToNodePath2(root, 10, new ArrayList<Integer>());
        System.out.println(path);
    }

    private static List<Integer> rootToNodePath2(TreeNode root, int node, List<Integer> ls) {
        if (root == null) {
            return null;
        } else if (root.val == node) {
            ls.add(node);
            return ls;
        } else {
            ls.add(root.val);
            var left = rootToNodePath2(root.left, node, ls);
            if (left != null) {
                return ls;
            }
            var right = rootToNodePath2(root.right, node, ls);
            if (right == null) {
                ls.remove(ls.size() - 1);
                return null;
            } else {
                return ls;
            }
        }
    }
}
