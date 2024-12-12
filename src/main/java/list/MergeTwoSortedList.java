package list;

import java.util.List;

public class MergeTwoSortedList {

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node next(int val) {
            this.next = new Node(val);
            return next;
        }

        @Override
        public String toString() {
            return val + (next != null ? " -> " + next : "");
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next(4).next(8).next(10);
        Node l2 = new Node(1);
        l2.next(3).next(3).next(6).next(11).next(14);
        Node res = null;
        Node curr = null;
        while (l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val > l2.val){
                    if(curr == null)
                        curr = new Node(l2.val);
                    else{
                        curr.next = new Node(l2.val);
                    }
                    l2 = l2.next;
                }else{
                    if(curr == null)
                        curr = new Node(l1.val);
                    else{
                        curr.next = new Node(l1.val);
                    }
                    l1 = l1.next;
                }
            }else if(l1 != null){
                if(curr == null)
                    curr = new Node(l1.val);
                else{
                    curr.next = new Node(l1.val);
                }
                l1 = l1.next;
            }else{
                if(curr == null)
                    curr = new Node(l2.val);
                else{
                    curr.next = new Node(l2.val);
                }
                l2 = l2.next;
            }
            if(res == null){
                res = curr;
            }
            if(curr.next != null){
                curr = curr.next;
            }
        }

        System.out.println(res);
    }

}
