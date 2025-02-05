package trees;

import java.util.*;

public class MaxWidthOfTree {

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
//        var path = getMaxWidthOfTree(root);
        Solution solution = new Solution();
        int val = solution.widthOfBinaryTree(root);
        System.out.println(val);
    }

    private static int getMaxWidthOfTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int max = Integer.MIN_VALUE;
        boolean next = true;
        boolean firstItr = true;
        while (next) {
            int n = list.size();
            int count = 0;
            int first = -1;
            int last = -1;
            for (int i = 0; i < n; i++) {
                TreeNode oth = list.remove(0);
                if (oth != null) {
                    if (first == -1) {
                        first = i;
                        last = i;
                    } else {
                        last = i;
                    }
                    count++;
                    list.add(oth.left);
                    list.add(oth.right);
                } else {
                    list.add(null);
                    list.add(null);
                }
            }
            if (last - first > max) {
                max = last - first + 1;
            }
            next = firstItr || count >= 2;
            firstItr = false;
        }
        return max;
    }

    static class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }
            int max = Integer.MIN_VALUE;
            Queue<TreeValue> queue = new LinkedList<>();
            queue.add(new TreeValue(root, 1));
            while(!queue.isEmpty()){
                int n = queue.size();
                List<TreeValue> children = new ArrayList<>();
                for(int i = 0; i < n ; i++){
                    TreeValue val = queue.remove();
                    if(val.node.left != null){
                        children.add(new TreeValue(val.node.left, val.value * 2 - 1));
                    }
                    if(val.node.right != null){
                        children.add(new TreeValue(val.node.right, val.value * 2));
                    }
                }
                queue.addAll(children);
                if(!children.isEmpty()){
                    max = Math.max(
                            Math.abs(children.get(0).value - children.get(children.size() - 1).value) + 1,
                            max
                    );
                }
            }
            return max;
        }
    }

    static class TreeValue {
        TreeNode node;
        int value;

        public TreeValue(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}
