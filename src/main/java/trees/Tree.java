package trees;

public class Tree {

    int val;
    Tree left;
    Tree right;

    public Tree setVal(int val) {
        this.val = val;
        return this;
    }

    public Tree setLeft(Tree left) {
        this.left = left;
        return this;
    }

    public Tree setRight(Tree right) {
        this.right = right;
        return this;
    }

    public Tree(int val) {
        this.val = val;
    }

    public Tree() {
    }
}
