package recursions;

public class HeightOfTree {

    public static void main(String[] args) {
        Tree tree = new Tree(10);
        tree.left = new Tree(20);
        tree.right = new Tree(30);
        tree.right.right = new Tree(40);
        tree.right.right.left = new Tree(50);
        int val = height(tree);
        System.out.println(val);
    }

    private static int height(Tree tree) {
        if(tree == null){
            return 0;
        }else{
            int left = height(tree.left);
            int right = height(tree.right);
            return Math.max(left, right) + 1;
        }
    }

    static class Tree{
        Tree left;
        Tree right;
        int val;

        Tree (int val){
            this.val = val;
        }
    }
}
