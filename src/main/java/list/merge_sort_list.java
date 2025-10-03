package list;

public class merge_sort_list {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        ListNode ans = solution.sortList(head);
        while (ans != null) {
            System.out.print(ans.val + (ans.next != null ? " --> " : ""));
            ans = ans.next;
        }
    }

    static class Solution {
        public ListNode sortList(ListNode head) {
            return mergeSort(head);
        }

        // Standard merge sort on singly linked list
        private ListNode mergeSort(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // Split list into two halves
            ListNode mid = getMiddle(head);
            ListNode rightHead = mid.next;
            mid.next = null; // break the list

            // Sort both halves
            ListNode leftSorted = mergeSort(head);
            ListNode rightSorted = mergeSort(rightHead);

            // Merge sorted halves
            return merge(leftSorted, rightSorted);
        }

        // Find middle node (end of first half)
        private ListNode getMiddle(ListNode head) {
            // For 2 nodes, return the first node as middle
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        // Merge two sorted lists
        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }

            // Attach remaining nodes
            tail.next = (l1 != null) ? l1 : l2;

            return dummy.next;
        }
    }
}