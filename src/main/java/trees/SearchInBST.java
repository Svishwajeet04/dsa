package trees;

public class SearchInBST {

    public static void main(String[] args) {
        Tree tree = new Tree(5)
                .setRight(new Tree(10)
                        .setRight(new Tree(12))
                        .setLeft(new Tree(9)));
        boolean found = searchBST(tree, 9);
        System.out.println(found);
    }

    private static boolean searchBST(Tree tree, int key) {
        while (tree != null){
            if(tree.val == key){
                return true;
            }else if(key < tree.val) {
                tree = tree.left;
            }else{
                tree = tree.right;
            }
        }
        return false;
    }
}
