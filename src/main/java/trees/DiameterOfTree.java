package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfTree {

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
        getDiameterOfTree(tree, max);
        System.out.println(max.get());
    }

    private static int getDiameterOfTree(Tree tree, AtomicInteger max) {
        if (tree == null) {
            return 0;
        }else{
            int rh = getDiameterOfTree(tree.right, max);
            int lh = getDiameterOfTree(tree.left, max);
            if(max.get() < (lh+ rh)){
                max.set(lh + rh);
            }
            return 1 + Math.max(lh, rh);
        }
    }
}
