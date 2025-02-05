package trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BoundaryTraversal {

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
        List<Integer> boundaryTraversal = new ArrayList<>(getSideTraversal(root, new ArrayList<>()));
        boundaryTraversal.addAll(getLeafNodes(root, new ArrayList<>()));
        boundaryTraversal.addAll(getRightSideNodes(root, new ArrayList<>()).stream().sorted(Comparator.reverseOrder()).toList());
        System.out.println(boundaryTraversal);
    }

    private static List<Integer> getRightSideNodes(TreeNode root, List<Integer> integers) {
        if (root.left == null && root.right == null) {
            return integers;
        } else {
            integers.add(root.val);
            if (root.right != null) {
                return getSideTraversal(root.right, integers);
            } else {
                return getSideTraversal(root.left, integers);
            }
        }
    }

    private static List<Integer> getLeafNodes(TreeNode root, List<Integer> integers) {
        if (root.left == null && root.right == null) {
            integers.add(root.val);
        } else {
            if (root.left != null) {
                getLeafNodes(root.left, integers);
            }
            if (root.right != null) {
                getLeafNodes(root.right, integers);
            }
        }
        return integers;
    }

    private static List<Integer> getSideTraversal(TreeNode root, List<Integer> integers) {
        if (root.left == null && root.right == null) {
            return integers;
        } else {
            integers.add(root.val);
            if (root.left != null) {
                return getSideTraversal(root.left, integers);
            } else {
                return getSideTraversal(root.right, integers);
            }
        }
    }
}
