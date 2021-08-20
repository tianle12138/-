package problem_0XX;

import domain.ListNode;

// 61. 旋转链表
public class _61 {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode tail = head;
        while(tail != null){
            len ++;
            if(tail.next == null) break;
            tail = tail.next;
        }
        k = k % len;
        while ((k--) != 0){
            tail.next = head;
            head = head.next;
            tail = tail.next;
            tail.next = null;
        }
        return head;
    }
}
