package List;

import java.util.List;

// 92. 反转链表 II
public class reverseII {
    public static void main(String[] args) {
        reverseII a = new reverseII();
        System.out.println(a.reverse(2147483647));
    }

    public int reverse(int x) {
        String s = "" + x;
        int pos = s.charAt(0) == '-' ? 1 : 0;
        String s1 = s.substring(pos, s.length());
        char[] chars = s1.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i ++;
            j --;
        }
        s1 = new String(chars);
        String max = "" + Integer.MAX_VALUE;
        if(s1.length() == max.length() && s1.compareTo(max) > 0){
            return -1;
        }
        return ((int)Integer.parseInt(s1)) * (pos == 0 ? 1 : -1);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverse(head, right);
        } else {
            ListNode newHead = reverseBetween(head.next, left - 1, right - 1);
            // if (left == 2) head.next = newHead;
            head.next = newHead;
            return head;
        }
    }


    ListNode postNode = null;

    public ListNode reverse(ListNode head, int n) {
        if (n == 1) {
            postNode = head.next;
            return head;
        }
        ListNode newhead = reverse(head.next, n - 1);
        head.next.next = head;
        head.next = postNode;
        return newhead;
    }


    // public ListNode reverseBetween(ListNode head, int left, int right) {
    //     if (head == null || head.next == null || left == right) {
    //         return head;
    //     }
    //
    //     if (left == 1) {
    //         ListNode newHead = reverse(head, right);
    //         return newHead;
    //     }
    //
    //     right = right - left + 1;
    //     ListNode preNode, curNode;
    //     preNode = head;
    //     curNode = head.next;
    //     while (--left != 1) {
    //         preNode = curNode;
    //         curNode = curNode.next;
    //     }
    //     preNode.next = reverse(curNode,right);
    //
    //     return head;
    // }
    //
    // ListNode postNode = null;
    //
    // public ListNode reverse(ListNode head, int right) {
    //     if (right == 1) {
    //         postNode = head.next;
    //         return head;
    //     }
    //     ListNode newhead = reverse(head.next, right - 1);
    //     head.next.next = head;
    //     head.next = postNode;
    //     return newhead;
    // }

}
