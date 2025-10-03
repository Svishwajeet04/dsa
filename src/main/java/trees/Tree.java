package trees;

public class Tree {
    int val;
    Tree left;
    Tree right;

    public Tree(int val) {
        this.val = val;
    }

    public Tree() {
    }

    public Tree getRight() {
        return right;
    }

    public Tree setRight(Tree right) {
        this.right = right;
        return this;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree setLeft(Tree left) {
        this.left = left;
        return this;
    }

    public int getVal() {
        return val;
    }

    public Tree setVal(int val) {
        this.val = val;
        return this;
    }

    public void printTreeStructure() {

    }
}
