package problem_4XX;
// 445. 两数相加 II
// 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
import java.util.Stack;

public class _445 {
    public static void main(String[] args) {
        ListNode p1 =  new ListNode(1,new ListNode(2,new ListNode(4,new ListNode(4))));
        ListNode p2 =  new ListNode(2,new ListNode(5,new ListNode(6,new ListNode(4))));
        _445 clazz = new _445();
        clazz.addTwoNumbers(p1,p2);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        while(l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry == 1){
            int val1 = s1.isEmpty() ? 0 : s1.pop();
            int val2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = val1 + val2 + carry;
            if(head == null){
                head = new ListNode(sum % 10);
            } else {
                ListNode listNode = new ListNode(sum % 10);
                listNode.next = head;
                head = listNode;
            }
            carry = sum / 10;
        }
        return head;
    }
        // int carry = 0;
    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     return recursion(l1,l2);
    // }
    //
    // private ListNode recursion(ListNode l1, ListNode l2) {
    //     if(l1.next == null){
    //         int sum = l1.val +l2.val;
    //         carry = sum > 9? 1:0;
    //         return new ListNode(sum % 10);
    //     }
    //
    //     ListNode last = recursion(l1.next, l2.next);
    //     int sum = l1.val +l2.val+carry;
    //     carry = sum > 9? 1:0;
    //     ListNode res = new ListNode(sum % 10);
    //     res.next = last;
    //     return res;
    // }
}
