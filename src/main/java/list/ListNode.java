package list;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode next(int val) {
        this.next = new ListNode(val);
        return next;
    }

    @Override
    public String toString() {
        return val + (next != null ? " -> " + next : "");
    }
}
