package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfTree {

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
        getDiameterOfTree(treeNode, max);
        System.out.println(max.get());
    }

    private static int getDiameterOfTree(TreeNode treeNode, AtomicInteger max) {
        if (treeNode == null) {
            return 0;
        }else{
            int rh = getDiameterOfTree(treeNode.right, max);
            int lh = getDiameterOfTree(treeNode.left, max);
            if(max.get() < (lh+ rh)){
                max.set(lh + rh);
            }
            return 1 + Math.max(lh, rh);
        }
    }
}
