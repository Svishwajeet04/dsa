package trees;

public class CielInBST {

    public static void main(String[] args) {
        Tree tree = new Tree(5)
                .setRight(new Tree(10)
                        .setRight(new Tree(12))
                        .setLeft(new Tree(9)));
        Integer ciel = getCiel(tree, 11);
        System.out.println(ciel);
    }

    private static Integer getCiel(Tree tree, int x) {
        int ciel = -1;
        while (tree != null){
            if(tree.val == x){
                ciel = tree.val;
                break;
            }else if(x > tree.val){
                tree = tree.right;
            }else{
                ciel = tree.val;
                tree = tree.left;
            }
        }
        return ciel;
    }
}
