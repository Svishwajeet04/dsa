package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxPathSum {
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
        AtomicInteger max = new AtomicInteger();
        getMaxPathSum(treeNode, max);
        System.out.println(max.get());
    }

    private static int getMaxPathSum(TreeNode treeNode, AtomicInteger max) {
        if(treeNode == null){
            return 0;
        }else{
            int rh = getMaxPathSum(treeNode.right, max);
            int lh = getMaxPathSum(treeNode.left, max);
            if(max.get() < (treeNode.val + rh + lh)){
                max.set(treeNode.val + rh + lh);
            }
            return treeNode.val + Math.max(rh, lh);
        }
    }
}
