package problem_0XX;

import domain.ListNode;

import java.util.List;

// 21. 合并两个有序链
public class _21 {


    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if(l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     if (l1 == null) return l2;
    //     if (l2 == null) return l1;
    //
    //     ListNode res = l1.val <= l2.val ? l1 : l2;
    //     while (l1!=null && l2!= null){
    //         if(l1.val<=l2.val) {
    //             while(l1.next != null && l1.next.val < l2.val) l1 = l1.next;
    //             ListNode temp = l1.next;
    //             l1.next = l2;
    //             l1 = temp;
    //         } else {
    //             while(l2.next != null && l2.next.val < l1.val) l2 = l2.next;
    //             ListNode temp = l2.next;
    //             l2.next = l1;
    //             l2 =temp;
    //         }
    //     }
    //     return res;
    //
    // }
}
