package trees;

public class MaxHeightOfTree {

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

        System.out.println(getMaxHeightOfTree(treeNode));
    }

    private static int getMaxHeightOfTree(TreeNode treeNode) {
        if(treeNode == null){
            return 0;
        }else{
            return Math.max(getMaxHeightOfTree(treeNode.left), getMaxHeightOfTree(treeNode.right))
                    + 1;
        }
    }
}
