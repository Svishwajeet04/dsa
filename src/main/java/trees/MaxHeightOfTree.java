package trees;

public class MaxHeightOfTree {

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

        System.out.println(getMaxHeightOfTree(tree));
    }

    private static int getMaxHeightOfTree(Tree tree) {
        if(tree == null){
            return 0;
        }else{
            return Math.max(getMaxHeightOfTree(tree.left), getMaxHeightOfTree(tree.right))
                    + 1;
        }
    }
}
