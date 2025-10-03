package list;

public class remove_dups_dll {

    public static void main(String[] args) {
        Solution solution = new Solution();
        DListNode head = new DListNode(2);
        head.next = new DListNode(2);
        head.next.prev = head;
        head.next.next = new DListNode(2);
        head.next.next.prev = head.next;
        head.next.next.next = new DListNode(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new DListNode(2);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new DListNode(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = new DListNode(2);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;

        System.out.println(head);
        head = solution.deleteAllOccurrences(head, 2);
        System.out.println(head);
    }

    static class Solution {
        public DListNode deleteAllOccurrences(DListNode head, int target) {
            while (head != null && head.val == target) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
            }
            DListNode curr = head;
            while (curr != null) {
                if (curr.val == target) {
                    curr.prev.next = curr.next;
                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                    }
                }
                curr = curr.next;
            }
            return head;
        }
    }
}
