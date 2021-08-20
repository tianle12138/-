package problem_8XX;

import domain.ListNode;

import java.util.HashSet;

// 817. 链表组件
public class _817 {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode fast,slow;
        fast = head;
        slow = head;
        int MAX_NUM = 0;
        int flag = 0;
        while(fast!=null){
            if(set.contains(fast.val)){
                if(flag == 0){
                    MAX_NUM ++;
                    flag = 1;
                }
                fast = fast.next;
            } else {
                flag = 0;
                fast = fast.next;
            }
        }
        return MAX_NUM;
    }
}
