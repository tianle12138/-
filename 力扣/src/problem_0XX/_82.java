package problem_0XX;

import domain.ListNode;

// 86. 分隔链表
public class _82 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode greatHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode great = greatHead;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                great.next = head;
                great = great.next;
            }
            head = head.next;
        }
        great.next = null;
        small.next = greatHead.next;
        return smallHead.next;

    }
}
