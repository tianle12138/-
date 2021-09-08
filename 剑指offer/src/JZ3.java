import domain.ListNode;

import java.util.ArrayList;
import java.util.List;

public class JZ3 {

    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        fun(listNode);
        return res;
    }

    private void fun(ListNode listNode) {
        if(listNode == null) return;
        fun(listNode.next);
        res.add(listNode.val);
    }
}
