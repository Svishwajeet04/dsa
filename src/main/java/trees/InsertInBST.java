package trees;

public class InsertInBST {
    public static void main(String[] args) {
        Tree tree = new Tree(5)
                .setRight(new Tree(10)
                        .setRight(new Tree(12))
                        .setLeft(new Tree(9)));
        insertInBST(tree, 3);
        insertInBST(tree, 4);
        insertInBST(tree, 1);
        System.out.println(true);
    }

    private static void insertInBST(Tree tree, int key) {
        while (tree != null) {
            if (key > tree.val) {
                if (tree.right == null) {
                    tree.right = new Tree(key);
                    return;
                } else {
                    tree = tree.right;
                }
            }else{
                if(tree.left == null){
                    tree.left = new Tree(key);
                    return;
                }else{
                    tree = tree.left;
                }
            }
        }
    }
}
