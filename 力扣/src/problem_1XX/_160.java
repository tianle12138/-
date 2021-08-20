package problem_1XX;

import domain.ListNode;

public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLen(headA);
        int lenB = getListLen(headB);
        int dif = Math.abs(lenA - lenB);

        if(lenA >= lenB){
            while (dif-- > 0){
                headA = headA.next;
            }
        } else {
            while (dif-- > 0){
                headB = headB.next;
            }
        }
        while (headA != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return  null;
    }
    int getListLen(ListNode li) {
        int len = 0;
        while(li!=null){
            len ++;
            li = li.next;
        }
        return len;
    }
}
