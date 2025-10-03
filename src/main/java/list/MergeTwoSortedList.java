package list;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next(4).next(8).next(10);
        ListNode l2 = new ListNode(1);
        l2.next(3).next(3).next(6).next(11).next(14);
        ListNode res = null;
        ListNode curr = null;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    if (curr == null)
                        curr = new ListNode(l2.val);
                    else {
                        curr.next = new ListNode(l2.val);
                    }
                    l2 = l2.next;
                } else {
                    if (curr == null)
                        curr = new ListNode(l1.val);
                    else {
                        curr.next = new ListNode(l1.val);
                    }
                    l1 = l1.next;
                }
            } else if (l1 != null) {
                if (curr == null)
                    curr = new ListNode(l1.val);
                else {
                    curr.next = new ListNode(l1.val);
                }
                l1 = l1.next;
            } else {
                if (curr == null)
                    curr = new ListNode(l2.val);
                else {
                    curr.next = new ListNode(l2.val);
                }
                l2 = l2.next;
            }
            if (res == null) {
                res = curr;
            }
            if (curr.next != null) {
                curr = curr.next;
            }
        }

        System.out.println(res);
    }

}
