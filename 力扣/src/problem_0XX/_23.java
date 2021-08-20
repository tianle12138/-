package problem_0XX;

import domain.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

// 23. 合并K个升序链表
public class _23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        int N = lists.length;
        for (int i = 0; i < N; ++i) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;

    }
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
}
