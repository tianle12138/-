package List;
//206
public class reverse {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))));
        reverse reverse = new reverse();
        reverse .reverseList(head);
    }

    //将以head节点为起点的链表反转并返回发转完成后新链表的头节点
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHeadNode = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }




    //将以head节点为起点的链表反转,并返回发转完成后新链表的尾结点
    // ListNode headnode = null;
    // public ListNode reverseList(ListNode head) {
    //     reverse(head);
    //     return headnode;
    // }
    // public ListNode reverse(ListNode head) {
    //     if(head == null || head.next == null) {
    //
    //         headnode = head;
    //         return head;
    //
    //     }
    //     //已经递归反转的子链尾节点
    //     ListNode list_last = reverse(head.next);
    //     //断开当前节点的next指针
    //     head.next = null;
    //     //把当前节点接到末尾
    //     list_last.next = head;
    //     return head;
    // }
}
