package trees;

public class FloorInBST {

    public static void main(String[] args) {
        Tree tree = new Tree(5)
                .setRight(new Tree(10)
                        .setRight(new Tree(12))
                        .setLeft(new Tree(9)));
        Integer ciel = getFloor(tree, 7);
        System.out.println(ciel);
    }

    private static Integer getFloor(Tree tree, int x) {
        int ciel = -1;
        while (tree != null){
            if(tree.val == x){
                ciel = tree.val;
                break;
            }else if(x > tree.val){
                ciel = tree.val;
                tree = tree.right;
            }else{
                tree = tree.left;
            }
        }
        return ciel;
    }
}
