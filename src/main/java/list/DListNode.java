package list;

class DListNode {
    int val;
    DListNode next;
    DListNode prev;

    DListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    DListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    DListNode(int data1, DListNode next1, DListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }

    @Override
    public String toString() {
        return val + (next != null ? " -> " + next : "");
    }
}