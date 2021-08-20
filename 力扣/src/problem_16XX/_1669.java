package problem_16XX;

import domain.ListNode;

public class _1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head1 = list1;
        ListNode tail2 = list2;
        while(tail2.next!= null) tail2 = tail2.next;
        ListNode prior,last;
        prior = list1;
        last = list1;
        while((b--) != a){
            last = last.next;
        }
        while ((--a) != 0){
            prior = prior.next;
            last = last.next;
        }
        prior.next=list2;
        tail2.next = last.next;

            return head1;
    }
}
