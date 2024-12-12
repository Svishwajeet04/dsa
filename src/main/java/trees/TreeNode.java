package trees;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;
    }


    public TreeNode() {
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }

    public TreeNode setVal(int val) {
        this.val = val;
        return this;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
