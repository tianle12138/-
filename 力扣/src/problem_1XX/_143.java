package problem_1XX;

import domain.ListNode;

import java.util.List;

public class _143 {

    public static void main(String[] args) {
        _143 cls = new _143();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        cls.reorderList(head);
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = getMid(head);
        ListNode t = mid;
        mid = mid.next;
        t.next = null;
        mid = revese(mid);

        ListNode start = head;
        while (mid != null) {
            ListNode a, b;
            a = start.next;
            b = mid.next;
            start.next = mid;
            mid.next = a;
            start = a;
            mid = b;
        }
    }

    private ListNode revese(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode newHead = revese(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    private ListNode getMid(ListNode node) {
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}

