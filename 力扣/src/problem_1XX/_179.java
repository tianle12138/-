package problem_1XX;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _179 {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                return s1.compareTo(s2);
            }
        });
        for (int num : nums) {
            queue.add(num);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty())
        {
            sb.append(queue.poll());
        }
        int prefix = 0;
        for (int i = 0; i < sb.length() - 1; i++) {
            if(sb.charAt(i) == '0') prefix ++;
            else break;
        }
        return sb.substring(prefix);
    }
}
