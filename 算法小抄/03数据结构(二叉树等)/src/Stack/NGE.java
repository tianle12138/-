package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 496. 下一个更大元素 I
public class NGE {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] ans = new NGE().nextGreaterElement(nums1, nums2);
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }

    //代码结构优化
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            map.put(nums2[i],s.isEmpty() ? -1:s.peek());
            s.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack();
        for (int i = nums2.length - 1; i >= 0; i--) {
            if (i == nums2.length - 1) {
                s.push(nums2[i]);
                map.put(nums2[i], -1);
            } else {
                int cur = nums2[i];
                // while (s.peek() <= cur && !s.isEmpty()){
                //     s.pop();
                // }
                while (!s.isEmpty() && s.peek() <= cur) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    map.put(nums2[i], -1);
                    s.push(cur);
                } else {
                    map.put(nums2[i], s.peek());
                    s.push(cur);
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }


}
