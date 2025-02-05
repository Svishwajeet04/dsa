package trees;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 2;
        treeNode.right = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.left.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(1);
        Solution solution = new Solution();
        int res = solution.sumNumbers(treeNode);
        System.out.println(res);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public int sumNumbers(TreeNode root) {
            List<Integer> ls = new ArrayList<>();
            sumNumbers(root, 0, ls);
            int sum = 0;
            for (int i : ls) {
                sum += i;
            }
            return sum;
        }

        public void sumNumbers(TreeNode root, int val, List<Integer> ls) {
            if (root.left == null && root.right == null) {
                ls.add(val * 10 + root.val);
            }
            if (root.left != null) {
                sumNumbers(root.left, val * 10 + root.val, ls);
            }
            if (root.right != null) {
                sumNumbers(root.right, val * 10 + root.val, ls);
            }
        }
    }
}
