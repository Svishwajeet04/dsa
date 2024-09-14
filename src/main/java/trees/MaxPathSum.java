package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxPathSum {
    public static void main(String[] args) {
        Tree tree = new Tree()
                .setVal(13)
                .setLeft(new Tree().setVal(1).setLeft(
                                new Tree().setVal(2)
                                        .setLeft(new Tree().setVal(4))
                                        .setRight(new Tree().setVal(5)
                                                .setLeft(new Tree(6))
                                                .setRight(new Tree(7))))
                        .setRight(new Tree(3)))
                .setRight(new Tree(14));
        AtomicInteger max = new AtomicInteger();
        getMaxPathSum(tree, max);
        System.out.println(max.get());
    }

    private static int getMaxPathSum(Tree tree, AtomicInteger max) {
        if(tree == null){
            return 0;
        }else{
            int rh = getMaxPathSum(tree.right, max);
            int lh = getMaxPathSum(tree.left, max);
            if(max.get() < (tree.val + rh + lh)){
                max.set(tree.val + rh + lh);
            }
            return tree.val + Math.max(rh, lh);
        }
    }
}
