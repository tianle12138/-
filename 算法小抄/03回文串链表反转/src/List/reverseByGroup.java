package List;


import java.util.List;

public class reverseByGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));
        reverseByGroup c = new reverseByGroup();
        c.reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode a,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if(b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next =  reverseKGroup(b, k);
        return newHead;
    }


    /**
     * 反转a到b的所有节点[a,b)
     * @param a
     * @param b
     * @return
     */
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode next = a;
        while(cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // public ListNode reverseKGroup(ListNode head, int k) {
    //     if(k == 1) return head;
    //     ListNode index = head;
    //     boolean is_first = true;
    //     ListNode preOldHead = head;
    //
    //     while (index != null) {
    //         ListNode curhead = index;
    //         int i = 0;
    //         for (i = 0; i < k; i++) {
    //         if (index == null) break;
    //             index = index.next;
    //         }
    //         if (i < k) break;
    //         ListNode newHead = reverse(curhead, k);
    //         if(is_first){
    //             is_first = false;
    //             head = newHead;
    //             preOldHead = curhead;
    //         } else {
    //             preOldHead.next = newHead;
    //         }
    //
    //     }
    //     return head;
    // }
    //
    // ListNode postNode;
    //
    // public ListNode reverse(ListNode node, int n) {
    //     if (n == 1) {
    //         postNode = node.next;
    //         return node;
    //     }
    //     ListNode newHead = reverse(node.next, n - 1);
    //     node.next.next = node;
    //     node.next = postNode;
    //     return newHead;
    // }


}
